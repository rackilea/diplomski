@CRUD.For(User.class)
public class Users extends CRUD {
   /**
    * Re-implement Create (C) method
    * @throws Exception
    */
   public static void create() throws Exception {
      // Get model type
      ObjectType type = ObjectType.get(getControllerClass());
      notFoundIfNull(type); // render not found error if framework can't determine model type
      Constructor<?> constructor = type.entityClass.getDeclaredConstructor();
      constructor.setAccessible(true);

      // Create new instance of model
      User object = (User) constructor.newInstance();
      // Bind all parameter value from submitted form
      Binder.bindBean(params.getRootParamNode(), "object", object);
      // Hash the password
      object.password = Crypto.passwordHash(object.email + object.password);

      // Check validity of model
      validation.valid(object);
      if (validation.hasErrors()) {
         renderArgs.put("error", play.i18n.Messages.get("crud.hasErrors"));
         try {
            render(request.controller.replace(".", "/") + "/blank.html", type, object);
         } catch (TemplateNotFoundException e) {
            render("CRUD/blank.html", type, object);
         }
      }
      object._save(); // Finally, save the model
      flash.success(play.i18n.Messages.get("crud.created", type.modelName));
      if (params.get("_save") != null) {
         redirect(request.controller + ".list");
      }
      if (params.get("_saveAndAddAnother") != null) {
         redirect(request.controller + ".blank");
      }
      redirect(request.controller + ".show", object._key());
   }

   /**
    * Re-implement Update (U) mehod
    * @param id
    * @throws Exception
    */
   public static void save(String id) throws Exception {
      // Get model type
      ObjectType type = ObjectType.get(getControllerClass());
      notFoundIfNull(type); // render not found error if framework can't determine model type

      // Find the model to be updated
      User object = (User) type.findById(id);
      notFoundIfNull(object); // render not found error if framework can't determine model record
      // Bind all parameter value from submitted form
      Binder.bindBean(params.getRootParamNode(), "object", object);
      // Hash the password
      object.password = Crypto.passwordHash(object.email + object.password);

      // Check validity of model
      validation.valid(object);
      if (validation.hasErrors()) {
         renderArgs.put("error", play.i18n.Messages.get("crud.hasErrors"));
         try {
            render(request.controller.replace(".", "/") + "/show.html", type, object);
         } catch (TemplateNotFoundException e) {
            render("CRUD/show.html", type, object);
         }
      }
      object._save(); // Finally, save changes
      flash.success(play.i18n.Messages.get("crud.saved", type.modelName));
      if (params.get("_save") != null) {
         redirect(request.controller + ".list");
      }
      redirect(request.controller + ".show", object._key());
   }
}
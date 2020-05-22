Form<YourClass> form = Form.form(YourClass.class).bindFromRequest();
 if (form.hasErrors()) {
     return badRequest();
 } else {
     ...
 }
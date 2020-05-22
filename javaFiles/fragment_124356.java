public class CheckUrl extends play.mvc.Action.Simple {

    public F.Promise<SimpleResult> call(Http.Context ctx) throws Throwable {

        String host = request().uri();

         if (condition one satisfied) {

             return F.Promise.pure(redirect("/someurl"));

        }else if (condition two satisfied){

         return F.Promise.pure(redirect(controllers.routes.SomeController.index()));

        }

}
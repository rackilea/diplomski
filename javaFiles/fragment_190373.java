import play.data.DynamicForm;
import play.data.Form;

public static Result cadastraPedidoNoBanco() {

    DynamicForm form = Form.form().bindFromRequest();

    if (form.data().size() == 0) {
        return badRequest("Expceting some data");
    } else {
        String response = "Client " + form.get("nome_cliente") + "has phone number " + form.get("telefone_cliente");

        return ok(response);
    }
}
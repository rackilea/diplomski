import java.util.List;
import java.util.Map;

import play.data.Form;
import forms.Pedido;
import play.data.validation.ValidationError;
import play.i18n.Messages;

public class Pedidos extends Controller {


    public static Result cadastraPedidoNoBanco() {
        Form<Pedido> form = Form.form(Pedido.class).bindFromRequest();

        if (form.hasErrors()) {
            String errorsMsg = "There are " + form.errors().size() + " errors... \n";

            // Of course you can skip listing the errors
            for (Map.Entry<String, List<ValidationError>> entry : form.errors().entrySet()) {
                String errorKey = entry.getKey();
                List<ValidationError> errorsList = entry.getValue();
                for (ValidationError validationError : errorsList) {
                    errorsMsg += errorKey + " / " + Messages.get(validationError.message()) + "\n";
                }
            }

            return badRequest(errorsMsg);
        }

        Pedido data = form.get();
        String response = "Client " + data.nome_cliente + " has phone number " + data.telefone_cliente;

        return ok(response);
    }

}
package forms;

import play.data.validation.Constraints;

public class Pedido {

    @Constraints.Required()
    @Constraints.MinLength(3)
    public String nome_cliente;

    @Constraints.Required()
    @Constraints.MinLength(9)
    public String telefone_cliente;

    @Constraints.Required()
    public Long some_number;
    //etc...
}
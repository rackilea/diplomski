@GET
@Path("calculadora/Modulo")
public String Modulo(@QueryParam("num1") double num1,@QueryParam("num2") double num2)    {
    return Double.toString($Modulo(num1,num2));
}

double $Modulo(@QueryParam("num1") double num1,@QueryParam("num2") double num2) {
    double resultado;
    resultado = num1 % num2;
    return resultado;
}
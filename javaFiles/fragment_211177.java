public String entrar() throws IOException{

Login loginTentativa = new Login(login, password);
 String result="";

int resultadoValidacao = controle.validaLogin(loginTentativa);

switch (resultadoValidacao) {
    case 0:
           result="first/1-dados-escola.xhtml";
    break;
    case 1:                         
           result="/user/principal.xhtml";
    break;

    default:
        System.out.println("Usuário não autenticado.");
}

return result;
 }
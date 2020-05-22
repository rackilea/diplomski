// if your method isn't supposed to return anything, simply make it void
public static void escolha() {
    Scanner userInput = new Scanner(System.in);
    // print some useful information when the application starts, so that the user knows
    // what to do
    System.out.println("Comandos disponiveis:");
    System.out
            .println("Ajuda; Fogo; Jogo; Resposta; Estado; Acaso; Reset; Sair;");
    String strEscolha = userInput.next();
    boolean sair = false; 

    do {
        // remove duplicate case by converting the input to lower letters
        switch (strEscolha.toLowerCase()) {
        case "ajuda":
            System.out.println("Comandos disponiveis:");
            System.out
                    .println("Ajuda; Fogo; Jogo; Resposta; Estado; Acaso; Reset; Sair;");
            // read the user input
            strEscolha = userInput.next();
            System.out.println(strEscolha);
            break;
        case "sair":
            System.out.println("Obrigado por jogar!");
            sair = true;
            break;
        default:
            System.out.println("Comando Invalido!");
        }

    } while (sair == false);
    // do not forget to close the scanner, it might cause a memory leak
    userInput.close();
}
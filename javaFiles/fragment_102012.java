for (int i = 0; i < tokenList.size(); i++) {
    String lexema = tokenList.get(i).getLexema();

    switch (lexema) {
        case "":
            tokenList.remove(i);
            i = i - 1;
            break;
        // Remove Espacos
        case " ":
            tokenList.remove(i);
            i = i - 1;
            break;
        // Remove Tabulações
        case "\t":
            tokenList.remove(i);
            i = i - 1;
            break;
        // Remove Quebras de Linha
        case "\n":
            tokenList.remove(i);
            i = i - 1; // DEIXAR SEM O BREAK
            break;
        // Remove Caractere Estranho
        case "\r":
            tokenList.remove(i);
            i = i - 1;
            break;
        default:
            break;
        }
}
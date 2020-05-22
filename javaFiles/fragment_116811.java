public static int lerInformação(String[][] alunos, int numAl) {
do {
    System.out.print("Nome do Aluno: ");
    alunos[numAl][0] = ler.next();
    System.out.print("Número do Aluno: ");
    ler.nextLine();
    alunos[numAl][1] = ler.next();
    numAl++;
} while(numAl < alunos.length && (!alunos[numAl-1][0].equalsIgnoreCase("FIM"))); //numAl - 1, instead.
return numAl;
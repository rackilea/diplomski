public static int lerInformação(String[][] alunos, int numAl) {
do {
    System.out.print("Nome do Aluno: ");
    alunos[numAl][0] = ler.next();
    if(alunos[numAl][0].equalsIgnoreCase("FIM") {
      break;
    }
    System.out.print("Número do Aluno: ");
    ler.nextLine();
    alunos[numAl][1] = ler.next();
    numAl++;
} while(numAl < alunos.length);
return numAl;
}
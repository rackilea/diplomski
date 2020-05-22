static double[] media(Alunos[] aluno) {
  // allocate memory for a double array of size aluno.length
  double[] media = new double[aluno.length];
  for (int i = 0; i < aluno.length; i++) {
    media[i] = (aluno[i].n1 + aluno[i].n2 + aluno[i].n3) / 3;
    System.out.println(aluno[i].nome + media[i]);
  }
  return media;
}
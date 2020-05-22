public void showList(){
for (int i = 0; i < dispensa.size(); i++)
  {
    Alimento  alimento = dispensa.get(i);
    System.out.println(alimento.getNome());
  }
}
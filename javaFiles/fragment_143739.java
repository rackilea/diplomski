public static void main(String[] args) {

  ...

  //form, iterate over each promotion
  List<String> promocaoNames = getPromocaoNames();
  for(String promocaoName : promocaoNames){
    driver.findElement(By.name("nomePromocao")).sendKeys(promocaoName);
    driver.findElement(By.name("dataInicioPromocao")).sendKeys("24/09/2015");
    driver.findElement(By.name("dataFimPromocao")).sendKeys("04/12/2049");

    ...
  }

  ...
}


public static List<String> getPromocaoNames (){
  List<String> lista = new ArrayList<String>();
  lista.add("promo1");             
  lista.add("promo2");
  lista.add("promo3");

  Collections.shuffle ( lista );
  return lista;
}
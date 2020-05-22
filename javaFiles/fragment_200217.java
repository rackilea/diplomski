WebElement selectElementMes = driver.findElement(By.id("sel_Mes");
Select select_mes = new Select(selectElementMes);
List<WebElement> allMes = select_mes .getOptions();

WebElement selectElementAnos = driver.findElement(By.id("sel_Ano");
Select select_anos = new Select(selectElementAnos);
List<WebElement> allAnos = select_anos .getOptions();


Iterator<WebElement> itr_meses = allMes.iterator();
Iterator<WebElement> itr_ano = allAnos.iterator();

while(itr_ano.hasNext()) {
    while(itr_meses.hasNext()) {
        System.out.println(itr_ano.next().getAttribute("value") + " -> " + itr_meses.next().getAttribute("value"));
    }
}
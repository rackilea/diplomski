@Page
PageObject testpage;

@Test(priority = 0)
public void digitarTexto() {

  WebElement inputNome = testpage.getInputNome();
  WebElement inputIdade = testpage.getInputIdade();

  inputNome.sendKeys("Diego");
  inputIdade.sendKeys("29");
}
// etc
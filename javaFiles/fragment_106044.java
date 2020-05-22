public class PageObject{
  @FindBy(id = "j_idt5:nome")
  private WebElement inputNome;

  @FindBy(id = "j_idt5:idade")
  private WebElement inputIdade;

  // getters
  public WebElement getInputNome(){
    return inputNome;
  }

  public WebElement getInputIdade(){
    return inputIdade;
  }

  // add some tools for your objects like wait etc
}
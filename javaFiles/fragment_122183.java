public class CustomSuggestBox extends SuggestBox {


 private String placeHolderText = "";

  public String getPlaceHolderText() {
   return placeHolderText;
  }

  public void setPlaceHolderText(String text) {
    placeHolderText = text;
    getTextBox().getElement().setAttribute("placeHolder", placeHolderText);
  }
}
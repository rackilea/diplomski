public class TypeEditor extends java.beans.PropertyEditorSupport {
  @Override
  public void setAsText(String text) throws IllegalArgumentException {
    if(text != null) {
      text = text.trim();
      if(text.equalsIgnoreCase("abc")) {
        setValue(Type.A);
      }
      else if(text.equalsIgnoreCase("xyz")) {
        setValue(Type.B);
      }
      else if(text.equalsIgnoreCase("pqr")) {
        setValue(Type.C);
      }
    }
  }
}
<button type="submit" value="Submit" name="buttonName">
<button type="submit" value="Clear" name="buttonName">


class MyAction extends ActionSupport {
   private String buttonName;
   public void setButtonName(String buttonName) {
      this.buttonName = buttonName;
   }
   public String execute() {
      if ("Submit".equals(buttonName)) {
         doSubmit();
         return "submitResult";
      }
      if ("Clear".equals(buttonName)) {
         doClear();
         return "clearResult";
      }
      return super.execute();
   }
}
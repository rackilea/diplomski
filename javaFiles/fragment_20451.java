public class FOO {

    TextBox txt = new TextBox(){
          public void onLoad(){
            this.addFocusHandler(new FocusHandler(){

                @Override
                public void onFocus(FocusEvent event) {
                    FOO.this.txt.setHeight("100px");
                }
            });
          }
        };


}
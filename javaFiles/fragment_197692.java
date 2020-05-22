public class Registration extends Composite{
       private SuperPuperHandler<MySavedObject> saveHandler;

       public void addSaveHandler(SuperPuperHandler<MySavedObject> saveHandler){
          this.saveHandler=saveHandler;
       }

       .....
       savebutton.addClickHandler(new ClickHandler() {
           public void onClick(ClickEvent clickEvent) {
              if(saveHandler!=null){
                  saveHandler.onFire(mysavedObject); 
              }               
          }
       });
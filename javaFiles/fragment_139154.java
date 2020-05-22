public class HelloWorld implements EntryPoint{
    //(1) Create the client proxy.
    private UserServiceAsync userService = (UserServiceAsync) GWT.create(UserService.class);
    public void onModuleLoad() {
        Button click=new Button("Click Here");
        Label name=new Label("Enter Name");
        Label passwrd=new Label("Enter Password");
        final TextBox t_name=new TextBox();
        final TextBox t_passwrd=new TextBox();
        click.addClickHandler(new ClickHandler() {
        public void onClick(ClickEvent ev) {
                 String temp_user=t_name.getText();
                 String temp_pass=t_passwrd.getText();   
                 /// (2) Create an asynchronous callback and Make the call
                 userService.loginUser(temp_user, temp_pass, new AsyncCallback<String>() {
                     public void onFailure(Throwable caught) {
                             Window.alert("Please enter valid details");
                      }

                     public void onSuccess(String result) {
                         Window.alert("Welcome");
                     }
                 });//end of service call
       });//end of clickhandler
        RootPanel.get().add(name);
        RootPanel.get().add(t_name);
        RootPanel.get().add(passwrd);
        RootPanel.get().add(t_passwrd);
        RootPanel.get().add(click);
    }
 }
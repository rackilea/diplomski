public class UserAction extends ActionSupport{

    public void validate(){
        if(!firstName.equals("JimB77")){
            //addFieldError(firstName, "first name is not equal to JimB77");    
            addActionError("You have an error on your inputs..");
        }
    }

    public String performAnalysis(){
        System.out.println("perform analysis logic..");
        return SUCCESS;
    }


    private String firstName;
    private String lastName;

    //getters and setters

}
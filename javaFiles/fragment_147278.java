public class InsertStuff {

    @Setter private String stuff = "";

    public String execute(){
        getService().insertStuff(stuff);
        return SUCCESS;
    }

    public void validate(){
        if (stuff.length()<3){
            addFieldError("stuff","The mininum length is 3");
        }
    }
}
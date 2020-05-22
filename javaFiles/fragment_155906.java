public class Foo extends ActionSupport implements iMyStaticStuff{
    public String execute(){
        System.out.println(myStaticList);
        return SUCCESS;
    }       
}
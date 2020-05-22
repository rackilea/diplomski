public class Motivate() 
{

    private static Map<String, Motivate> motivations;
    private String action;
    private String description;

    private Motivate(String action, String description)
    {
        this.action=action;
        this.description=description;
    }
    public void init()
    {
        if(motivations == null)
        {
            build motivations using all the stuff in the first example
        }
    }
}
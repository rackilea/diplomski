public class exampleClass {

    public void main()
    {

    nextMethod(defineVariable());
    }

    void nextMethod(String[] list)
    {
    list[8] = "threw away";
    }

    private String tab[] defineVariable()
    {
    String[] list= {"trivial string","more trivial strings","just another trivial string","tr","a","sd",
                     "godzilla","ate","my","pony","and homework","trivial"};
       return list
    }

    }
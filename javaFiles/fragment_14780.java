public class Tester
{
    private String name;
    private int age;

    // Parameterized constructor  
    private Tester(String myName, int myAge)
    {
        this.name = myName;
        this.age = myAge; 
    }
    public static Tester getTester(String mn, int ag){
        if(age>0){return new Tester(mn, ag);}
        else if(age>80){return new OldPersonThatExtendsTester(mn, ag);} 
        //we'd need a public or otherwise accessible constructor above. It's a subtype!
        else {return null;} //yes, this is possible
    }
}
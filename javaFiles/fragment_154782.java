public class Cat
{
    //instance variables: each object will have its own unique copies with different data
    String name, type, furColor;
    int age;

    //default constructor (basic cats with no info)
    public Cat()
    {
        this.name = null;//default for object types is null, String is object type
        this.type = null;
        this.furColor = null;
        this.age = 0;//default for int types is 0 or equivalent
    }

    //normal constructor: used for most constructions, takes parameters to initialize data 
    //(this is what you need for your basketball guy, although not every instance var needs a parameter in the constructor--refer to task guidelines)
    public Cat(String name, String type, String furColor, int age)
    {
        this.name = name;//if this confuses you, remember, this refers to current object instance,
        //but name will just search in scope, starting with lowest, til it finds reference. So it finds String name in param list first and uses that
        this.type = type;//bad example; type could now technically be "aslkdjf"
        this.furColor = furColor;
        this.age = age;
    }

    //an example getter/setter
    public void setName(String name){this.name = name;}//i'm not making pretty cuz time
    public String getName(){return this.name;}
    //if you decide to actually mess with this, add getters/setters for the rest of the data for the cat to really feel power
    //example cat method(s)--you can add more
    public String Meow(){return (this.name + " says, \"Meow!\"");}//returns string so main can print
    public String Eat(){return (this.name + " licks the bowl greedily...");}

    public static void main(String[] args)
    {
        Cat cat1 = new Cat();//data is blank
        cat1.setName("Jack");//if you comment this line out and run, you should get a null reference error because the name is null
        //please try messing with getters/setters so you can initialize all the data if you have time
        System.out.println(cat1.Meow() + "\n" + cat1.Eat());
        Cat cat2 = new Cat("Boris", "Calico", "White/Blonde", 13);//has actual data now because of constructor
        System.out.println(cat2.getName() + "'s day: \n" + cat2.Meow() + "\n" + cat2.Eat());
    }
}
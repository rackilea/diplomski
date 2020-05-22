public class human { //Here you declare a class 

    //This is a field with package-private (default) permissions
    //might be also called a variable or a parameter
    int age; 
    String name;
    String hairColor;
    String gender;

    public human() { //This is a constructor

    }

    public void speaking() { //This is a method not a constructor
        System.out.println("my name is " + name);
        System.out.println("my age is " + age + " years old");
        System.out.println("my hair color is " + hairColor);
        System.out.println("my gender is " + gender);
    }

    //Main is the first method to be called when program executes, it is 
    //program's entry point
    public static void main(String args[]) { 
        //This is an object better known as an instance
        human earthHuman = new human();

        //These are parametes
        earthHuman.age = (18); 
        earthHuman.name = ("dan");
        earthHuman.hairColor = ("black brownish");
        earthHuman.gender = ("male");

        //Calling method speaking on earthHuman instance
        earthHuman.speaking();
    }
}
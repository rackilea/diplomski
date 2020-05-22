public class Person{
    public String getName(String name) {
        // Why would the user pass a value they want returned right back to them?
        return name; 
    }
    public int getAge(int age){
        // Same here as well. This needs to be addressed!
        return age;
    }
 }
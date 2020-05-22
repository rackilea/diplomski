String nameString = "com.example.Test";
Class name = Class.forName(nameString);
Object instance = name.newInstance();
Test test; // Defined if is instanceof Test

if(instance instanceof Test) {
    // Yeah! now you can do this: test = (Test)instance; and something else...
}
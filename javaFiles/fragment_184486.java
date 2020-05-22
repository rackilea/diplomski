@groovy.transform.Field 
def myFun = {-> "Hello World"}

class MyClass {
    String getLabel(script) {
        return ""+ script.myFun();
    }
}

System.err.println(new MyClass().getLabel(this))
class OuterClass{
    public static class StaticNestedClass{
    }

    public class InnerClass{
    }

    public InnerClass getAnInnerClass(){
        return new InnerClass();
    }

    //This method doesn't work
    public static InnerClass getAnInnerClassStatically(){
        return new InnerClass();
    }
}

class OtherClass{
    //Use of a static nested class:
    private OuterClass.StaticNestedClass staticNestedClass = new OuterClass.StaticNestedClass();

    //Doesn't work
    private OuterClass.InnerClass innerClass = new OuterClass.InnerClass();

    //Use of an inner class:
    private OuterClass outerclass= new OuterClass();
    private OuterClass.InnerClass innerClass2 = outerclass.getAnInnerClass();
    private OuterClass.InnerClass innerClass3 = outerclass.new InnerClass();
}
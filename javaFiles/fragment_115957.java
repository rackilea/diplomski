public interface CommonTestParameter {

    String getStuff();
    Object getMoreStuff();
}

public class TestParameterImpl implements CommonTestParameter {

    private final String stuff;
    private final Object moreStuff;

    public TestParameterImpl(String aStuff, Object aMoreStuff){
        this.stuff = aStuff;
        this.moreStuff = aMoreStuff;
    }

    @Override
    public String getStuff(){
        return this.stuff;
    }

    @Override
    public Object getMoreStuff(){
        return this.moreStuff;
    }

    @Override
    public String toString(){
        return "stuff = \"" + this.stuff + "\", moreStuff = \"" + this.moreStuff.toString() + "\"";
    }
}
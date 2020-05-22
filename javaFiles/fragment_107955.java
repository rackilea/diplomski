public class Base{
    protected String getXMLFile(){
        return "BaseXML";
    }

    public void foo(){
        if(getXMLFile() ....){
            ...
        }
    }
}

public class Test{
    @Override
    protected String getXMLFile(){
        return "TestXML";
    }
}
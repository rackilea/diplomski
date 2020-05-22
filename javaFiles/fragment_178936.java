import org.apache.log4j.PatternLayout;  
public class CustomePatternLayout extends PatternLayout {  

    @Override  
    public String getHeader() {  
        return "id, event time, message, status"  
    }  

}
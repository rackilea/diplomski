@com.googlecode.objectify.annotation.Entity
public class Insight {
    @com.googlecode.objectify.annotation.Id 
    public Long id;

    @com.googlecode.objectify.annotation.Index  // *** This was missing ***
    public boolean downloaded = false;

    public Insight () { }

}
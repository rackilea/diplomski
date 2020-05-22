import org.jboss.seam.Component;
import org.jboss.seam.annotations.*;
import org.jboss.seam.log.Log;

@Name("foo")
@AutoCreate
public class Foo {
    @Logger Log log;
    @In Bar bar;

    @Create
    public void init()  {
        log.info("Init: #0", bar);
        log.info("Init: #0", Component.getInstance("bar"));
    }
}




import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.Name;

@Name("bar")
@AutoCreate
public class Bar { }
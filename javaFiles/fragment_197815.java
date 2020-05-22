package upload;

import java.util.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@ApplicationPath("web")
public class MyApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        return new HashSet<Class<?>>(Arrays.asList(UploadResource.class  ));
    }

}
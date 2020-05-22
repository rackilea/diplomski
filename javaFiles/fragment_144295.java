import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Path("/webservice")
public class WebService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Object getResponse(){  
        //firstName,LastName,Age,Id
        Student std1 = new Student("ik","test",22,2);
        Student std2 = new Student("John","Vector",23,3);
        Student std3 = new Student("iks","Roy",25,4);
        List<Student> stuList = new ArrayList<Student>();
        stuList.add(std1);
        stuList.add(std2);
        stuList.add(std3);
        Gson gson = new GsonBuilder().create();
        return gson.toJson(stuList);
    }
}
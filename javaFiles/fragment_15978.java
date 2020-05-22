import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet(name = "JSONResponseExample", urlPatterns = {"/JSONResponseExample"})
public class JSONResponseExample extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final PrintWriter writer = response.getWriter();
        final JSONArray jsonArray = new JSONArray();

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");        

        JSONObject item1 = new JSONObject();
        item1.put("id", "1");
        item1.put("name", "name 1");
        item1.put("email", "Email Adderess 1");
        jsonArray.put(item1);

        JSONObject item2 = new JSONObject();
        item2.put("id", "2");
        item2.put("name", "name 2");
        item2.put("email", "Email Adderess 2");
        jsonArray.put(item2);

        Writer jsonWriter = jsonArray.write(writer);
        jsonWriter.close();
    }
}
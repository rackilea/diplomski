import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet(value = "/TestGsonHttp")
public class TestGsonHttp extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Your class
        MyJson m = new MyJson();
        m.setName("frederico");

        Gson g = new Gson();
        String jsonResult = g.toJson(m);

        PrintWriter writer = resp.getWriter();
        writer.print(jsonResult);
        writer.flush();
        writer.close();
    }

    class MyJson {

        private String  name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
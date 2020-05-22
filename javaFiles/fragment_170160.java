package mypackage;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import flexjson.JSONSerializer;

@WebServlet("/JSONExample")
public class JSONExample extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public JSONExample() {
    super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        //use the id to retrieve the list you want

        //some list of things
        List<Object> list = new ArrayList<Object>();
        list.add(1);
        list.add(id);
        list.add(new Date());
        list.add("Hello");

        //now serialize
        JSONSerializer serializer = new JSONSerializer();
        String json = serializer.serialize(list);
        response.setContentType("application/json");

        //print it
        PrintWriter out = response.getWriter();
        out.write(json);
        out.flush();
    }
}
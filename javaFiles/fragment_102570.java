import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

import static java.lang.System.out;

public class sample extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String city = request.getParameter("cities");
        String numbers = request.getParameter("matrix");
        int[] abc=new int[100];
        String[] args = new String[2];
        args[0] = city;
        args[1] = numbers;
        abc = TSPNearestNeighbour.main(args);  //passing the two arguments to my java class
        PrintWriter out = response.getWriter();

        for (int i=0;i<=abc.length;i++) {
            out.println(abc[i]);
        }

    }
}
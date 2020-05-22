**MVC Architecture with JSP and Servlet**

    **Model**

    public class StudentBean {

        private int rno;
        private String name;
        private float fee;

        public StudentBean() {

        }

        public int getRno() {
            return rno;
        }

        public void setRno(int rno) {
            this.rno = rno;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public float getFee() {
            return fee;
        }

        public void setFee(float fee) {
            this.fee = fee;
        }

        @Override
        public String toString() {
            return "StudentBean [rno=" + rno + ", name=" + name + ", fee=" + fee + "]";
        }

    }

    **View**

        <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
            pageEncoding="ISO-8859-1"%>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Insert title here</title>
        </head>
        <body>

            <form  method="get" action="StudentController">

                Rno: <input type="text" name="rno"/> <br/>
                Name: <input type="text" name="name"/> <br/>
                Fee: <input type="text" name="fee"/> <br/>
                <input type="submit" name="btnSubmit" value="Submit"/>
            </form>
        </body>
        </html>

    **Controller**

    import java.io.IOException;
    import javax.servlet.ServletException;
    import javax.servlet.annotation.WebServlet;
    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;


@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StudentBean studentBean = new StudentBean();
        studentBean.setRno(Integer.parseInt(request.getParameter("rno")));
        studentBean.setName(request.getParameter("name"));
        studentBean.setFee(Float.valueOf(request.getParameter("fee")));


        System.out.println(studentBean);

        request.getSession().setAttribute("studentObject", studentBean);
        request.getServletContext().getRequestDispatcher("/output.jsp").forward(request, response);
    }

}

**another page, where bean is being used.**

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"   pageEncoding="ISO-8859-1"%>
<%@ page import="com.loardscrat.controller.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Hello</h1>
<%
    StudentBean studentBean = (StudentBean) request.getSession().getAttribute("studentObject");
    out.print(studentBean.getRno());
    out.print(studentBean.getName());
    out.print(studentBean.getFee());

%>
</body>
</html>
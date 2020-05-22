import javax.servlet.http.HttpServlet;

public class SendSMS extends HttpServlet {
    private static final long serialVersionUID = 100L;

    @Override
    public void init() {
        String cellNumber = getServletConfig().getInitParameter("cellnumber");
        String text = getServletConfig().getInitParameter("text");

        new SMSProvider().sendSMS(cellNumber, text);
    }
}
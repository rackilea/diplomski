public class MailServlet extends HttpServlet {
    public  void doPost(HttpServletRequest request,HttpServletResponse response)
                                  throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        response.setContentType("text/html");

        Message message =new MimeMessage(session1);

        message.setFrom(new InternetAddress("someone@something.com"));
        message.setRecipients(...);
        message.doSomeOtherStuff();
        Transport.send(message);

        out.println("mail has been sent");
    }
}
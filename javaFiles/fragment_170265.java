@WebServlet(urlPatterns={"/processFile"}, asyncSupported=true)
@MultipartConfig
public class CorreoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // (2) Save client's file
        final Part filePart = request.getPart("file"); // <input name="file" ...

        ...

        AsyncContext asyncContext = req.startAsync();
        asyncContext.start(new Runnable() {
            @Override
            public void run() {
                // (4) Process client's file
                // (5) Send result to client's email.
            }
        });

        // (3) Show "Your result will ...

    }

}
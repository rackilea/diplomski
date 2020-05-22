public class PushServlet extends HttpServlet {

    private boolean processing = true;
    private HttpServletResponse response;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.response = response;
        configureAndStart();
        while (processing) {
            try {
                sendMessages();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void configureAndStart() throws IOException {
        processing = true;
        response.setContentType("text/event-stream; charset=utf-8");
        sendMessage(new SSEMessageBean(SSEEventType.START));
    }

    private void sendMessages() throws IOException, InterruptedException {
        SSEMessageBean message = MessageQueueController.getInstance().getNextMessage();
        while (message != null) {
            sendMessage(message);
            message = MessageQueueController.getInstance().getNextMessage();
            if (message.getEventType() != SSEEventType.END)
                return;
        }
        Thread.sleep(10000);
        sendMessage(new SSEMessageBean(SSEEventType.KEEP_ALIVE));
    }

    public void sendMessage(SSEMessageBean message) throws IOException {
        SSEMessageConverter converter = new SSEMessageConverter();
        PrintWriter out = response.getWriter();
        out.print(converter.convert(message));
        out.flush();
        if (message.getEventType() == SSEEventType.END) {
            processing = false;
            out.close();
        }
    }
}
public class YourCustomView implements View {

    private final String errorMessage;

    public YourCustomView(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        response.setContentType("text/plain;charset=UTF-8");
        try (PrintWriter pw = response.getWriter()) {
            pw.write(errorMessage);
        }
    }

}
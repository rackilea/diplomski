@Override
void init(ServletConfig config) throws ServletException {
    try {
        super.init();
    } catch (Throwable t) {
        // Do something

        throw t;
    }
}
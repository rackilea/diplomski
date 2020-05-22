public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Map<String, String> newProperties = ...; // get new map from jdbc call
    synchronized (lock) {
        properties = newProperties;
    }
}
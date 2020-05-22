@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    // Get the body of the request
    BufferedReader reader = request.getReader();

    // Print each line
    String line;
    while ((line = reader.readLine()) != null){
        System.out.println(line);
    }
}
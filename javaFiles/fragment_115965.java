public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{
   // Step 1
   String serverName = request.getLocalName();
   String contextPath = request.getContextPath();

   URL url = new URL("https://" + serverName + contextPath + "/baz");
   HttpURLConnection connection = (HttpURLConnection) url.openConnection();
   connection.setRequestProperty("Key Header", request.getHeader("Key Header"));

   BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

   // Step 2
   ... // Do something with the data from the reader

   // Step 3
   ... // Write the data back using the response
}
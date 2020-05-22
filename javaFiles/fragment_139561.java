Servlet B (On server that receives IP as query parameter)

String ip = getAttribute("IP");
if( hasSharedFile(ip) ) {
  list = fetchList(ip); // Basically an ArrayList<String>
  // SEND THIS LIST BACK TO THE CLIENT

    Gson gson = new Gson();
    gson.toJson(list, resp.getWriter());

} else {
   // Return a message saying,No file has been shared till with the server
  }
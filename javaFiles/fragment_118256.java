BufferedOutputStream bos = new BufferedOutputStream(connection.
      getOutputStream());

  /** Instantiate an OutputStreamWriter object with the optional character
   * encoding.
   */
  OutputStreamWriter osw = new OutputStreamWriter(bos, "US-ASCII");

  String process = "Calling the Socket Server on "+ host + " port " + port;

  /** Write across the socket connection and flush the buffer */
  osw.write(process);
  osw.flush();
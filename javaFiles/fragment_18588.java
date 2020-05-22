StringBuffer instr = new StringBuffer();

  /** Establish a socket connetion with the server*/
  Socket connection = new Socket(address, port);

  /** Instantiate a BufferedOutputStream object */
  BufferedOutputStream bos = new BufferedOutputStream(connection.getOutputStream());

  /** Instantiate an OutputStreamWriter object with the optional character
   * encoding. Sending some message to server
   */
  OutputStreamWriter osw = new OutputStreamWriter(bos, "US-ASCII"); 
  String process = "SAMPLE COMMAND SENT TO SERVER"+(char)13;

  /** Write across the socket connection and flush the buffer */
  osw.write(process);
  osw.flush();

  // NOW READING THE RESPONSE FROM THE SERVER
  // I HAVE ADDED THE CHAR(13) as the delimiter here
  /** Instantiate a BufferedInputStream object for reading
  /** Instantiate a BufferedInputStream object for reading
   * incoming socket streams.
   */

  BufferedInputStream bis = new BufferedInputStream(connection.getInputStream());
  /**Instantiate an InputStreamReader with the optional
   * character encoding.
   */

  InputStreamReader isr = new InputStreamReader(bis, "US-ASCII");

  /**Read the socket's InputStream and append to a StringBuffer */
  int c;
  while((c=isr.read())!=13)
    instr.append((char)c);

  /** Close the socket connection. */
  connection.close();
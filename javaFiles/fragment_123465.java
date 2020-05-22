public abstract interface javax.activation.DataSource {

  // Method descriptor #4 ()Ljava/io/InputStream;
  public abstract java.io.InputStream getInputStream() throws java.io.IOException;

  // Method descriptor #8 ()Ljava/io/OutputStream;
  public abstract java.io.OutputStream getOutputStream() throws java.io.IOException;

  // Method descriptor #10 ()Ljava/lang/String;
  public abstract java.lang.String getContentType();

  // Method descriptor #10 ()Ljava/lang/String;
  public abstract java.lang.String getName();
}
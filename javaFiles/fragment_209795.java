import java.io.*;
import java.net.Socket;
import java.util.StringTokenizer;

/**
 * Web Server Request Handler.
 * Created on 2015-02-16.
 */

public class RequestHandler implements Runnable {

    /*
    TODO ( ) Problem 1
    TODO ( ) Problem 2
    TODO ( ) Problem 3
    TODO (X) Index page for first page.
    TODO (X) Read and download images & other files
    TODO ( ) Fix header responses
    TODO ( ) Error responses
     */

    private String
            OK = "HTTP/1.0 200 OK",
            NOT_FOUND = "HTTP/1.0 404 Not Found",
            BAD_REQUEST = "HTTP/1.0 400 Bad Request",
            FORBIDDEN = "HTTP/1.0 403 Forbidden",
            SERVER_ERROR = "HTTP/1.0 500 Internal Server Error";

    private String ROOT_DIR;
    private Socket client;
    private PrintStream send;
    private DataInputStream fromClient;
    // private DataOutputStream out;

    RequestHandler(Socket client, String ROOT_DIR) {
        this.client = client;
        this.ROOT_DIR = ROOT_DIR;

        try {
            send = new PrintStream(client.getOutputStream());
            fromClient = new DataInputStream(client.getInputStream());
            // out = new DataOutputStream(new BufferedOutputStream(client.getOutputStream()));


        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    /* Reads the HTTP request and responds */
    public void run() {
        String request = null;
        String fileName = null;
        StringTokenizer tok = null;

        try {

            /* Read HTTP request from client */
            while ((request = fromClient.readLine()) != null) {

                System.out.println(request);
                tok = new StringTokenizer(request);

            /* Extracts the file path from the GET command */
                if (tok.hasMoreElements() && tok.nextToken().equals("GET")
                        && tok.hasMoreElements()) {

                    fileName = tok.nextToken();
                } else
                    throw new FileNotFoundException();

                /* */
                if (fileName.endsWith("/"))
                    fileName += "index.html";

                /* Illegal characters, prevent access to super directories */
                if (fileName.indexOf("..") >= 0 || fileName.indexOf('|') >= 0
                        || fileName.indexOf(':') >= 0 || fileName.indexOf('~') >= 0) {

                    error(FORBIDDEN, "Forbidden Access", fileName);
                }
                else

                if (new File(fileName).isDirectory()) {
                    fileName = fileName.replace('\\', '/');
                    send.close();
                    return;
                }

            /* File name is ROOT_DIR + file name */
                fileName = ROOT_DIR + fileName;

            /* Create file */
                File file = new File(fileName);

                if (file.isDirectory()) {
                    fileName = fileName + "index.html";
                }
            /* File does not exist */
                if (file.exists()){
            /* Determines the MIME type of the file */
                    String mimeType = getMimeType(file);

            /* Sends the file */
                    sendFile(file, mimeType, fileName);
                    client.close();
                }
                else
                    error(NOT_FOUND, "404 File Not Found", fileName);
            }

        }
        catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
        catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    /* Sends the requested file to the client */
    public void sendFile(File file, String fileType, String fileName) {
        try {
            // Buffer must not be to low, => fragments
            int length = 0; // (int) file.length();
            FileInputStream fileIn = new FileInputStream(fileName);
            byte[] bytes = new byte[1024];
            ByteArrayOutputStream bos = new ByteArrayOutputStream();

            /* Write until bytes is empty */
            while ((length = fileIn.read(bytes)) != -1 ){
                bos.write(bytes, 0, length);
                // send.write(bytes, 0, length);
                // send.flush();
            }
            bos.flush();
            bos.close();
            byte[] data1 = bos.toByteArray();

            System.out.print(new String(data1));
            send.print(OK);
            send.print("");
            send.print("Server: Jakobs Web Server v1.0");
            send.print("Content-Type: " + fileType + "\r\n");
            send.print("Content-Length: " + data1.length + "\r\n");
            send.println("");
            send.write(data1, 0, data1.length);
            send.println("");

            send.flush();
            send.close();

            fileIn.close();

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    /* Sends the header response to the client */
    public void sendHeaderResponse(String code, String fileType){
        try {
            send.print(code);
            send.print("Server: Jakobs Web Server v1.0");
            send.print("Content-Type: " + fileType + "\r\n");
            send.print("");
            send.println();
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    /* Sends error response to the client */
    public void error(String code, String error, String fileName){
        System.err.println(error +
                "\nFile Requested: " + fileName);

        /* Sends the error code header */
        sendHeaderResponse(code, fileName);

        // send.println("ERROR");

        /* Sends the error message and cause to client */

        send.print("<html><head><title>" + error + "</title></head><body>");
        send.print("<h1>" + error + "</h1>\r\n");
        send.println("Location: /" + fileName + "/\r\n");
        send.println("Exception Cause: " + error + "\r\n");
        send.print("<a href=\"index.html\">Start Page</a>");
        send.print("</body></html>");

        send.flush();
        send.close();
    }

    /* Finds out the MIME type of the requested file */
    public String getMimeType(File f) {
        String file = f.toString();
        String type = "";
        if (file.endsWith(".txt")) {
            type = "text/txt";
        } else if (file.endsWith(".html") || file.endsWith("htm")) {
            type = "text/html";
        } else if (file.endsWith(".jpg")) {
            type = "image/jpg";
        } else if (file.endsWith(".png")) {
            type = "image/png";
        } else if (file.endsWith(".jpeg")) {
            type = "image/jpeg";
        } else if (file.endsWith(".gif")) {
            type = "image/gif";
        } else if (file.endsWith(".pdf")) {
            type = "application/pdf";
        } else if (file.endsWith(".mp3")) {
            type = "audio/mpeg";
        } else if (file.endsWith(".class")){
            type = "application/octet-stream";
        } else if (file.endsWith(".mp4")){
            type = "video/mp4";
        }
        return type;
    }
}
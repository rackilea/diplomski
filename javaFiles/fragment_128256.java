package ir.cclever.example;

import java.awt.List;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WellCloseWebServer {

    public class clientInfo{
        public String ip;
        public Date visitTime;
    }

    static ArrayList<clientInfo> clients = new ArrayList<clientInfo>();

    public  void start() throws IOException {
        ServerSocket listener = new ServerSocket(8181,1000);
        System.out.println("Webserver starting up on port 8181");
        System.out.println("Waiting for connection");

        //==========================regex
        String pathRegex = "(?<=GET /).+?(?= HTTP)";

        Pattern pathPattern = Pattern.compile(pathRegex);
        //==========================/regex

        try {
            while (true) {
                Socket socket = listener.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String wholeRequest = "";
                String line;

                String requestHeaders = in.readLine();
                wholeRequest = wholeRequest.concat(requestHeaders + "\n<br>");

                while(!(line = in.readLine()).equals("")){
                    wholeRequest = wholeRequest.concat(line + "\n<br>");
                }

                wholeRequest = wholeRequest.concat("\n<br/>\n<br/>\nClient IP Address : " + socket.getRemoteSocketAddress().toString());
                wholeRequest = wholeRequest.concat("\n<br/>\n<br/>\nClient Opened Port : " + ((Integer)socket.getPort()).toString());

                clientInfo newClient = new clientInfo();
                newClient.ip = socket.getRemoteSocketAddress().toString();
                newClient.visitTime = new Date();
                clients.add(newClient);

                Matcher pathMatcher = pathPattern.matcher(requestHeaders);

                Boolean anyPath = pathMatcher.find();

                System.out.println("Connection, sending data to request : " + requestHeaders);
                try {
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                    if (!anyPath) {
                        JustHello(out);
                    }
                    else {
                        String directory = pathMatcher.group();

                        System.out.println(directory);

                        if (directory.toString().equals("pic")) {
                            JustPic(out);
                        }
                        else if(directory.toString().startsWith("server/")){
                            getFile(directory,dos,true);
                        }
                        else if(directory.toString().endsWith("jpg")){
                            getFile(directory,dos,false);
                        }
                        else if(directory.toString().equals("my.aspx")){
                            mirror(out,wholeRequest);
                        }
                        else if(directory.toString().equals("clients.html")){
                            WholeClients(out);
                        }
                        else{
                            errorPage(out);
                        }
                    }
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } finally {
                    socket.close();
                }
            }
        }
        finally {
            listener.close();
        }
    }

    private void InvalidRequestMethod(PrintWriter out, String string) {
        // TODO Auto-generated method stub
        out.println("HTTP/1.0 404 NOT FOUND");
        out.println("Content-Type: text/html");
        out.println("Server: Bot");
        // this blank line signals the end of the headers
        out.println("");
        out.flush();
        // Send the HTML page
        out.print("<!DOCTYPE html>\n<html>\n<head>\n<title>Just GET</title>\n<meta charset=\"UTF-8\">\n</head>\n<body>\nInvalid request mehtod! : "+ string +"\n</body>\n</html>");
        out.flush();
    }

    private void errorPage(PrintWriter out) {
        // TODO Auto-generated method stub
        out.println("HTTP/1.0 404 NOT FOUND");
        out.println("Content-Type: text/html");
        out.println("Server: Bot");
        // this blank line signals the end of the headers
        out.println("");
        out.flush();
        // Send the HTML page
        out.print("<!DOCTYPE html>\n<html>\n<head>\n<title>Error 404 NOT FOUND!</title>\n<meta charset=\"UTF-8\">\n</head>\n<body>\nContent not found on server!\n</body>\n</html>");
        out.flush();
    }

    private void WholeClients(PrintWriter out) {
        // TODO Auto-generated method stub
        out.println("HTTP/1.0 200 OK");
        out.println("Content-Type: text/html");
        out.println("Server: Bot");
        // this blank line signals the end of the headers
        out.println("");
        out.flush();
        // Send the HTML page
        out.print("<!DOCTYPE html>\n<html>\n<head>\n<title>Whole Clients</title>\n<meta charset=\"UTF-8\">\n</head>\n<body>\n");
        Integer i=0;
        for (clientInfo item : clients) {
            i++;
            out.print("<br/>\n"+i.toString()+") ip : " + item.ip + " | visit time : " + item.visitTime.toString());
        }
        out.print("\n</body>\n</html>");
        out.flush();
    }

    private void mirror(PrintWriter out, String requestHeaders) {
        // TODO Auto-generated method stub
        out.println("HTTP/1.0 200 OK");
        out.println("Content-Type: text/html");
        out.println("Server: Bot");
        // this blank line signals the end of the headers
        out.println("");
        out.flush();
        // Send the HTML page
        out.print("<!DOCTYPE html>\n<html>\n<head>\n<title>My Info</title>\n<meta charset=\"UTF-8\">\n</head>\n<body>\n" +
                requestHeaders.toString() +
                "\n</body>\n</html>");
        out.flush();
    }

    private void getFile(String directory, DataOutputStream os, boolean b) {
        String CRLF = "\r\n";
        // Open the requested file.
        String fileName = directory;
        FileInputStream fis = null;
        boolean fileExists = true;
        try {
        //(new File(fileName)).mkdirs();
        fis = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
        fileExists = false;
        }

        // Construct the response message.
        String statusLine = null;
        String contentTypeLine = null;
        String entityBody = null;
        if (fileExists) {
        statusLine = "200 OK" + CRLF;
        contentTypeLine = "Content-type: " + 
                contentType( fileName ) + CRLF;
        } else {
        statusLine = "404 NOT FOUND" + CRLF;
        contentTypeLine = "Content Not Found!" + CRLF;
        entityBody = "<HTML>" + 
            "<HEAD><TITLE>Not Found</TITLE></HEAD>" +
            "<BODY>Not Found</BODY></HTML>";
        }

        // Send the status line.
        try {
            if (b) {
                os.writeBytes(statusLine);
                // Send the content type line.
                os.writeBytes(contentTypeLine);
                // Send a blank line to indicate the end of the header lines.
                os.writeBytes(CRLF);
            }
            // Send the entity body.
            if (fileExists) {
            sendBytes(fis, os);
            fis.close();
            } else {
            os.writeBytes("File DNE: Content Not Found!");
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static String contentType(String fileName) {
        if(fileName.endsWith(".htm") || fileName.endsWith(".html")) {
            return "text/html";
        }
        if(fileName.endsWith(".jpeg") || fileName.endsWith(".jpg")) {
        return "image/jpeg";
        }
        if(fileName.endsWith(".gif")) {
        return "image/gif";
        }
        if(fileName.endsWith(".png")) {
            return "image/png";
            }
        if(fileName.endsWith(".js")) {
            return "text/javascript";
            }
        if(fileName.endsWith(".css")) {
            return "text/stylesheet";
            }

        return "application/octet-stream";
        }

    private static void sendBytes(FileInputStream fis, OutputStream os) 
        throws Exception {
        // Construct a 1K buffer to hold bytes on their way to the socket.
        byte[] buffer = new byte[1024];
        int bytes = 0;

        // Copy requested file into the socket's output stream.
        while((bytes = fis.read(buffer)) != -1 ) {
            os.write(buffer, 0, bytes);
            }
        }

    private void JustHello(PrintWriter out) {
        // TODO Auto-generated method stub
        out.println("HTTP/1.0 200 OK");
        out.println("Content-Type: text/html");
        out.println("Server: Bot");
        // this blank line signals the end of the headers
        out.println("");
        out.flush();
        // Send the HTML page
        out.print("<!DOCTYPE html>\n<html>\n<head>\n<title>Just Hello</title>\n<meta charset=\"UTF-8\">\n</head>\n<body>\nHello World\n</body>\n</html>");
        out.flush();
    }

    private void JustPic(PrintWriter out) {
        // TODO Auto-generated method stub
        out.println("HTTP/1.0 200 OK");
        out.println("Content-Type: text/html");
        out.println("Server: Bot");
        // this blank line signals the end of the headers
        out.println("");
        out.flush();
        // Send the HTML page
        out.print("<!DOCTYPE html>\n<html>\n<head>\n<title>Just Pic</title>\n<meta charset=\"UTF-8\">\n</head>\n<body>\n<img src=\"/images/th.jpg\"/>\n</body>\n</html>");
        out.flush();
    }
}
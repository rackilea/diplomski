public void run()
{
           //Create a reader to read the request from client
            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));

           //from client get the line
            String line = reader.readLine();

            //file name client sends or use default one
            String filename = "";

            //file to read
            File file = null;

           //split the request with (space) as separator
            String parts[] = line.split(" ");

           // if we don't have exactly 3 words, return
            if (parts.length != 3) {
                return;
            }

           // if first part is GET
            if (parts[0].compareTo("GET") == 0) {
                //second word is the file name
                filename = parts[1].substring(1);

                //if filename is favicon.ico then print 404 not found
                if (filename.equals("favicon.ico")) {
                    System.out.println("404 File Not Found!");
                    return;
                } else {
                    //else print the file name
                    System.out.println(filename);
                }
            }

           //tell the requiting client the request was successful
            printToBrowser(bos, "HTTP/1.1 200 OK");
            //i think this is to indicate end of line
            printToBrowser(bos, "");

            if (filename.equals("")) { 
                file = new File("index.txt"); //if there is no file name set the file to index.txt
            } else {
                file = new File(filename); //else of the file name
            }

            try {   
                FileInputStream input = new FileInputStream(file); //read the file
                int a; 
                byte[] buffer = new byte[1024]; //create a buffer of 1024 bytes could also use BufferedReader

                while ((a = input.read(buffer, 0, 1024)) > 0) { //read the file   
                    sleep(100); //sleep, not sure why this is here
                    bos.write(buffer, 0, a); //send the file to client
                }   

            } catch (Exception e) {
                //TODO : handle the error more gracefully, also indicate to client
                System.err.println(e.getMessage()); 
           }
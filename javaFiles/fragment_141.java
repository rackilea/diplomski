public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.#     
        int portNumber = 15000;

        try (

            ServerSocket serverSocket =  new ServerSocket(portNumber);

            Socket clientSocket = serverSocket.accept();     


            OutputStream os = clientSocket.getOutputStream();
            PrintWriter out = new PrintWriter(os, true);               
            //BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            InputStream is = clientSocket.getInputStream();

        ) {

            //RECV
            //Create ByteBuffer for length integer
            ByteBuffer bLength = ByteBuffer.allocate(4);
            //C is usually Little_Endian
            bLength.order(ByteOrder.LITTLE_ENDIAN);
            //Read 4 bytes
            is.read(bLength.array(), 0, 4);
            //Convert the length
            int length = bLength.getInt();
            System.out.println("Length: "+length);


            //Allocate ByteBuffer for message
            ByteBuffer bMessage = ByteBuffer.allocate(length);
            bMessage.order(ByteOrder.LITTLE_ENDIAN);
            is.read(bMessage.array(), 0, length);
            //Convert the message to string
            String msg = new String( bMessage.array() );
            System.out.println(msg);


            //SEND
            //Create ByteBuffer with length
            ByteBuffer bLengthNew = ByteBuffer.allocate(4);
            bLengthNew.order(ByteOrder.LITTLE_ENDIAN);
            bLengthNew.putInt(msg.length());

            //Write the length bytebuffer to the outputstream
            os.write(bLengthNew.array());

            //Write the message to the outputstream. (Don't use println)
            out.print(msg);
            //Flush it. (It automatically gets flushed on a \n, but we dont want that.
            out.flush();

        } catch (IOException e) {

            System.out.println("Exception caught when trying to listen on port "

            + portNumber + " or listening for a connection");

            System.out.println(e.getMessage());

        }



    }
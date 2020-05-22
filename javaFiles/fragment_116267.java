public void run(){
        // Try to open reader
        try{
            readSock = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        } catch (Exception e){
            System.out.println(e);
        }

        // Open output stream
        try{
            this.out = new DataOutputStream(sock.getOutputStream()); // Data output
            this.printOut = new PrintWriter(sock.getOutputStream()); // Print output
        } catch (Exception e){
            System.out.println(e);
        }

        // Try to read incoming line
        try {
            this.reqMes = readSock.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringTokenizer st = new StringTokenizer(reqMes);

        // Parse the request message
        int count = 0;
        while(st.hasMoreTokens()){
            String str = st.nextToken();
            if (count == 1){
                this.fileName = "." + str;
            }
            count += 1;
        }
        System.out.println("File name received.");

        // Initialize file to be sent
        File file = null;
        // Try to find file and create input stream
        try {
            file = new File(this.fileName);
            this.f = new FileInputStream(file); // File input stream
            this.fileExists = true;
            System.out.println("File " + this.fileName +  " exists.");
        } catch (FileNotFoundException e) {
            System.out.println(e);
            this.fileExists = false;
            System.out.println("File does not exist.");
        }

        byte[] buffer = new byte[1024];
        // Write status line
        if (this.fileExists) {
            System.out.println("Trying to write data");
            try{
                this.out.writeBytes("HTTP/1.0 " + "200 OK " + this.CRLF);
                this.out.flush();
                // Write Header
                this.out.writeBytes("Content-type: " + getMime(this.fileName) + this.CRLF);
                this.out.flush();
                this.out.writeBytes(this.CRLF);
                this.out.flush();

                // Read file data
                byte[] fileData = new byte[1024];

                int i;
                while ((i = this.f.read(fileData)) > 0) {
                    // Write File data
                    try{
                        this.out.write(fileData,0, i);
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                }
                this.out.flush(); // Flush output stream
                System.out.println("Flushed");
                closeSock(); // Closes socket
            } catch (IOException e) {
                e.printStackTrace();
            }
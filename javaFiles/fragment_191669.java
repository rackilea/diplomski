public NewClient(Socket s) {
            this.socket = s;
            this.id = ++uniqueID;
            try{
                in = new Scanner(socket.getInputStream());
                out = new PrintWriter(socket.getOutputStream());
                sdf = new SimpleDateFormat("HH:mm:ss");
            }catch(Exception e) {
                System.out.println("Exception while creating input/output streams: " + e);
            }
        }
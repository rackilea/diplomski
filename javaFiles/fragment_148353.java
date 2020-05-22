private static class Handler extends Thread{
    private Socket socket;

    public Handler(Socket socket){
        this.socket = socket;
    }

    public void run(){
        try(BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
            while(true){
                String line = in.readLine();
                System.out.print(line);
                double result = parseExecution(line);
                out.write("" + result + "\n");
                out.flush();
            }
        }catch(IOException e){
            e.printStackTrace();
        }

    }
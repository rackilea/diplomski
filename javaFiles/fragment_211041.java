public static void main(String[] args){
    try{
        Socket socket = new Socket("localhost", 12345);
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out.write("HELO\n"); //print("HELO\n") and println("HELO") should work too.
        out.flush();
        System.out.println("Server says " + in.readLine());
        in.close();
        out.close();
        socket.close();
    }catch(IOException e){e.printStackTrace();}
}
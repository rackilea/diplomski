public static void main(String[] args){
    try{
        Socket socket = new Socket(HOST_ADDRESS, PORT);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(bufferedReader.readLine());
        bufferedReader.close();
        socket.close();
    }catch(IOException e){}
}
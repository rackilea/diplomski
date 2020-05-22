String x = outToServer.readLine();
//while x doesn't equal whatever readLine would return if there's nothing to read
//I'm not sure if this is a null String or not
while(x!=null){
    System.out.print(x);//print it however you wish
    String x = outToServer.readLine();
}
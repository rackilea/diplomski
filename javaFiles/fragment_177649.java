BufferedReader input;
input = new BufferedReader(new InputStreamReader(s.getInputStream()));

Then:
while(true){
    try{
        input.readLine();//Read from server
    }
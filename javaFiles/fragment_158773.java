BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
String line;
while((line = br.readLine())!=null){
    // you can stop taking input when input line is empty
    if(line.isEmpty()){  
        break;
    }
    System.out.println(line); // printing the input line  
}
br.close();
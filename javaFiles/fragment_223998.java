BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
Thread.sleep(7000); //Sleep for 7 seconds
while (stdInput.ready()) { //While there's something in the buffer
     //read&print - replace with a buffered read (into an array) if the output doesn't contain CR/LF
    System.out.println(stdInput.readLine()); 
}
p.destroy(); //The buffer is now empty, kill the process.
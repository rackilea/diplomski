BufferedOutputStream buffOut = new BufferedOutputStream(new FileOutputStream("costam0.webm"));       
int bytesRead;
while ((bytesRead = input.read(buffer)) != -1){
    System.out.println(bytesRead);
    output.write(buffer, 0, bytesRead);
}
buffOUt.flush()
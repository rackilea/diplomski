BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
char[] buffer = new char[16 * 1024]; // 16 KiB buffer, change size if needed
long startedReadingAt = System.currentTimeMillis(); //When did we start reading?
while (System.currentTimeMillis() - startedReadingAt < 7000) { //While we're waiting
    if (stdInput.ready()){
        int charsRead = stdInput.read(buffer); //read into the buffer - don't use readLine() so we don't wait for a CR/LF
        System.out.println(new String(buffer, 0, charsRead));  //print the content we've read
    } else {
        Thread.sleep(100); // Wait for a while before we try again
    }
}
p.destroy(); //Kill the process
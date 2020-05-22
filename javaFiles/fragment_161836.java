public class BigFileReader implements Runnable {
    public static final String SENTINEL = "SENTINEL"; //the actual value isn't very important
    ...

    while((str=br.readLine())!=null) {
        linesRead.put(str);
    }
    //when reading the file is done, add SENTINEL to the queue
    linesRead.put(SENTINEL);
}

//inside BigFileProcessor...
while ( (line = linesToProcess.take()) != null) {
    // check if value in queue is sentinel value
    if (line == BigFileReader.SENTINEL) {
         //break out of the while loop
         break;
    }
    //otherwise process the line as normal
}
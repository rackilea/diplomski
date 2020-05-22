public class WriteToOutputFile implements Runnable{
BlockingQueue<entry> queue;
File file;
volatile boolean processentries;
WriteToOutputFile(BlockingQueue queue,File file){
this.queue = queue;
this.file = file;
this.processentries= tue;
}

@override 
public void run(){
while(processentries && !queue.isEmpty()){
  entry = queue.take();

if (entry== lastentry)break;
//logic to write entries to file 
} }

public void stop(){
processentries = false;
queue.put(lastentry);
}
}
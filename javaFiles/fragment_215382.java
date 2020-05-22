public InputStream getMP3Data(List<String> synthText){
  List<GetMP3Stream> threads=new ArrayList<GetMP3Stream>();
  // start a thread for each MP3 source
  for(String part: synthText){
    Thread thr=new GetMP3Stream(part);
    thr.start();
    threads.add(thr);
  }
  // collect opened input streams in a list
  List<InputStream> streams=new ArrayList<InputStream>();
  for(GetMP3Stream thr: threads){
    thr.join();
    streams.add(thr.res);
  }
  //Concatenate all input streams 
  return  new java.io.SequenceInputStream(streams);
}

class GetMP3Stream extends Thread {
 String url;
 InputStream res;
 GetMP3Stream (String url) {
   this.url=url;
 }
 public void run() {
   res=getMP3Data(url);
 }
}
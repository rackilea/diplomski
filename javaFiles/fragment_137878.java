Map<FingerprintData, Long> stream1Timestamps = new HashMap<>();
Map<FingerprintData, Long> stream2Timestamps = new HashMap<>();

StreamClass stream1 = howEverYouFetchStream(1);
StreamClass stream2 = howEverYouFetchStream(2);

while(true /*or if you have conditional to terminate place it here*/){
     FingerprintData stream1fpd = stream1.getFingerprintData();
     FingerprintData stream2fpd = stream2.getFingerprintData();

     if(stream1Timestamps.keySet().contains(stream2fpd)){
         Long firstHeard = stream1Timestamps.get(stream2fpd);
         System.out.println("stream 2 is delayed:" +System.nanoTime()-firstHeard + " nanoseconds");
         stream1Timestamps.remove(stream2fpd);
     }else{
         stream2Timestamps.put(stream2fpd, System.nanoTime();
     }

     if(stream2Timestamps.keySet().contains(stream1fpd)){
         Long firstHeard = stream2Timestamps.get(stream1fpd);
         System.out.println("stream 1 is delayed:" +System.nanoTime()-firstHeard + " nanoseconds");
         stream2Timestamps.remove(stream1fpd);
     }else{
         stream1Timestamps.put(stream1fpd, System.nanoTime();
     }

  }
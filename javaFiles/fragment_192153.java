----------.
for(int i=0;i<batch.length;i++){               |
                                               |           
    MultiThread gt=new MultiThread();       <--'

    gt.setBatch(batch[i]);                  
    gt.start();
    System.out.println("Thread started for "+batch[i]);
}
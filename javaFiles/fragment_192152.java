MultiThread gt=new MultiThread();
for(int i=0;i<batch.length;i++){
    gt.setBatch(batch[i]);                  

    gt.start();              <--- Same thread object as in previous iteration

    System.out.println("Thread started for "+batch[i]);
}
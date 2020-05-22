new Thread(() -> {
  int min;       
  int temp;  

  final int delayMillis = 100;
  long startTickTime = System.nanoTime();
  for (int index = 0; index < list.length-1; index++){          
    synchronized(myPanel){
        min = index;          
        for (int scan = index+1; scan < list.length; scan++)             
          if (list[scan] - (list[min]) < 0) min = scan;           

        // Swap the values          
        temp = list[min];          
        list[min] = list[index];
        list[index] = temp;
    }
    myPanel.repaint();
    try {
        TimeUnit.NANOSECONDS.sleep(delayMillis*1000000-System.nanoTime()+startTickTime);
        startTickTime = System.nanoTime();
    } catch (Exception e) {                 
        e.printStackTrace();
    }
  }
}).start();
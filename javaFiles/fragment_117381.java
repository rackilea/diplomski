Thread t1 = new Thread(()-> {
   for (int i=0;i<10000;++i)
      synchronized(lock) {
          sum += array[i];
      }
});
...
t1.start();
....

t1.join();
...
t4.join();

System.out.println(sum);
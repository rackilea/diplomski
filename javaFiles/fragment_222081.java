for (int i = 0; i < t.length; ++i)  {
    t[i] = new Thread(new Thread1(c, i, values, l));
    t[i].start();
}

for (int i = 0; i < t.length; ++i)  {
    try{
        t[i].join();
    }catch(InterruptedException e){
        Thread.currentThread().interrupt();//don't expect it but good practice to handle anyway
    }
}
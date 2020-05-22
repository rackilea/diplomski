ForkJoinTask[] tasks = new ForkJoinTask[myarray.length];
for(i=0,i<myarray.length, i++) 
{ 
    int j = i; // need an effectively final copy of i
    tasks[i] = ForkJoinPool.commonPool().submit(() -> {
        Webdriver.start();
        WebElement.findby.(By.name("field1").sendkeys(myArray[j][2]);
        Webdriver.end();
    });
}
for (i = 0; i < my array.length; i++) {
    tasks[i].join();
}
try {
  System.out.println(Thread.currentThread().getName() + " is sleeping");
  Thread.sleep(5000);
} catch (InterruptedException e) {
  e.printStackTrace();
}
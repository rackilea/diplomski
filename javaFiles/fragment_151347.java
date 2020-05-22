Thread t = new Thread() {
    public void run() {
        driver.findElement(By.xpath(elementXpath)).click();
    }
};

t.setName("runThread");
t.start();
try {
    t.join(3000); // <--- Timeout specified in milliseconds
}
catch (InterruptedException e) { // ignore
}
if (t.isAlive()) { // Thread still alive, we need to abort
    System.out.println("Timeout on loading on xpage "+ monkeyPath);
    t.interrupt();
}
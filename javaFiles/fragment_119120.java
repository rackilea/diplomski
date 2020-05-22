boolean driverCreated = false;
int retryCnt = 3;
int count = 0;
while(!driverCreated && count < retryCnt) {
  try {
    driver = new FirefoxDriver(null, ffp, cap);
    driverCreated = true;
    System.out.println("Driver Created");
  } catch (Exception e) {
    retryCnt++;
  }
}
if(driverCreated == false) { return null; }
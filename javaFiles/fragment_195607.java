int maxRetries = 3;
int retry = 0;
Exception thrown = null;

while (retry < maxRetries) {
  try {
    callFunction();
    break;
  } catch (Exception e) {
    thrown = e;
    retry++;
    warn("callFunction failed. Retrying.." + retry);
  }
}

if (retry == maxRetries) {
  warn("reached max");
  thrown.printStackTrace();
}
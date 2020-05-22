private static int currentRetryCount = 0;

public static void main(String[] args) throws InterruptedException {
    retryRead(20);
}

public static void retryRead(int maxRetryCount) throws InterruptedException {
    if (currentRetryCount <= maxRetryCount) {
        try {
            System.out.println("try count " + currentRetryCount);
            URLConnection conn;
            conn = new URL("").openConnection();
            conn.setReadTimeout(5000);
            conn.getInputStream();
            // if nothing happens,it just return
            return;
        } catch (Exception e) {
            // if exception raises,it will try again after 5 seconds
            Thread.sleep(5000);

            currentRetryCount++;
            retryRead(maxRetryCount);
        }
    }
}
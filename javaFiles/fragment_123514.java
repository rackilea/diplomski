private static final int MAX_RETRIES = 3 ;
    private static final int WAIT_BETWEEN_RETRIES_SEC = 30 ;

    public static void main(String... args) 
    {
        int retry = 1;
        while (retry <= MAX_RETRIES) {
            try {
                readFile();
                break;
            } catch (IOException e) {
                e.printStackTrace();
                retry++;
                try {
                    Thread.sleep(WAIT_BETWEEN_RETRIES_SEC * 1000);
                } catch (InterruptedException e1) {}
            }
        }
        if (retry == MAX_RETRIES) {
            System.out.println("Failed!");
            return;
        }
        // success
    }

  private static void readFile() throws IOException {
     //read file code
  }
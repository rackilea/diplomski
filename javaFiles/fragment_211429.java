try {
        ProcessBuilder pb =
           new ProcessBuilder(
              "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe", 
              "youtube.com");

        pb.start();

        System.out.println("Google Chrome launched!");
    } catch (IOException e) {
        e.printStackTrace();
    }
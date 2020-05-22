try {
        Runtime.getRuntime().exec(
          new String[]{"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe", 
                       "youtube.com"});

        System.out.println("Google Chrome launched!");
    } catch (Exception e) {
        e.printStackTrace();
    }
BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    for (int i = 0; i < 20; i++) {
        try {
            sleep(1000);
            if (in.ready()) {
                break;
            } else {
                System.out.println(i+" seeconds have passed");
            }
        } catch (InterruptedException | IOException ex) {
        }
    }
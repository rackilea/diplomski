public static void main(String[] args) {
        int num = 0;
        System.out.println("Start...");
        for (int i = 0; i < 54000; i++) {
            try {
                new User("Bob", 25);
                num++;
            } catch(OutOfMemoryError e) {
                break;
            }
        }
        System.out.println("Objects created before error: " + num);
        showInfo();
        System.out.println("Finish.");
    }
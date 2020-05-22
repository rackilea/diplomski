if (selectedOption == 1) {
    Timer t = new Timer();
    t.schedule(new TimerTask() {
        boolean flag = true;

        @Override
        public void run() {
            if (!flag) {
                System.out.println("Standby Mode Disabled");
            } else {
                System.out.println("Standby Mode Enabled");
            }
            flag = !flag;
        }
    }, 0, 3);
} else {
     System.out.println("Invalid input");
}
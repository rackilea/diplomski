if(!getDays().get(i).isEmpty()) {
    final int runnableI = i;
    Runnable listen = new Runnable() {
         @Override
        public void run() {
            if(!getDays().get(runnableI).equals("Everyday")) {
            ....
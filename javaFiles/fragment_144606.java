private static final Object lock = new Object();

synchronized(lock) {
    if (datalist.size() > 0) {
        float all = 0;
        for (int i = 0; i < datalist.size(); i++) {
            all += datalist.get(i).getCompletionRate(); //line 96
        }

        progressbar.setProgress(Math.round(all / datalist.size()));
    }
}
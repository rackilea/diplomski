private class MyTask implements Runnable {
    @Override
    public void run() {
        while (true) {
            MyObject object = queue.poll();
            if (object.time + DateUtils.MILLIS_PER_DAY * 30 > System.currentTimeMillis()) {
                display(object);
            } else {
                queue.add(object);
            }
        }
    }
}
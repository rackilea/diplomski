public void run() {
    while(true) {
        if (!queue.isEmpty()) {
            Object obj = queue.poll();
            System.out.println(obj.toString());
        }
    }
}
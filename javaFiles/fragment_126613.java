public void werk(Queue<Object[]> q, ExecutorService executorService) {
    executorService.submit(() -> {
        try {
            Object[] o = q.remove();
            try {
                String html = downloadHTML(o); // this takes one of your object arrays and returns the text of an html page

                insertIntoDB(html); // this is the code in the latter half of your downloadURL method
            }catch (/*narrow exception type indicating download failure*/Exception e) {
                werk(q, executorService);
            }
        }catch (NoSuchElementException e) {}
    });
}
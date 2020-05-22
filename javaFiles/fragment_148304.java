ExecutorService exec = (ExecutorService)servletContext
.getAttribute("converter pool");

exec.submit(new Runnable() {
    public void run() {
        // your code for transformation goes here
    }
}
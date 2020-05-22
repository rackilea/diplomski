private class RunnableInstance implements Runnable {

    protected Docket docket;

    public void run() {
        //do your stuff with the docket
    }

    public void setDocket(Docket docket) {
        this.docket = docket;
    }

}
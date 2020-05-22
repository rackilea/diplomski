final Task<Boolean> login = doLogin();
login.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
    @Override
    public void handle(WorkerStateEvent t) {
        // This handler will be called if Task succesfully executed login code
        // disregarding result of login operation

        // and here we act according to result of login code
        if (login.getValue()) {
            System.out.println("Successful login");
        } else {
            System.out.println("Invalid login");
        }

    }
});
login.setOnFailed(new EventHandler<WorkerStateEvent>() {
    @Override
    public void handle(WorkerStateEvent t) {
        // This handler will be called if exception occured during your task execution
        // E.g. network or db connection exceptions
        System.out.println("Connection error.");
    }
});
new Thread(login).start();
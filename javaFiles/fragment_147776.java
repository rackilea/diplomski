public void run()
    {
        toggleState();
        System.out.println("System State: " + state);
        edgeAlerts.offer(state);
    }
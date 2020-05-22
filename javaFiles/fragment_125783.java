public void start() {
        this.running = true;
        while (this.running) {
            displayMenu();
            getUserChoice().action.run();
        }
    }
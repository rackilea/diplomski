Inventory inventory = new Inventory();
    inventory.doSomething();
    inventory.setStrategy(new Strategy() {

        @Override
        public void doSomething() {
            System.out.println("strategy is now something different");
        }

    });
    inventory.doSomething();
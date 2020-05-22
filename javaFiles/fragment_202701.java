Consumer<Trader> consumer1 = new Consumer<Trader>() {

            @Override
            public void accept(Trader trader) {
                trader.updateBonus(2);
            }};

        Consumer<Trader> consumer2 = new Consumer<Trader>() {

            @Override
            public void accept(Trader trader) {
                // do something
            }};
        // Add bonus to each trader.
        traders.forEach(consumer1.andThen(consumer2));
Car car = optional.map(id -> getCar(id))
            .orElseGet(() -> {
                Car c = new Car();
                c.setName(carName);
                return c;
            });
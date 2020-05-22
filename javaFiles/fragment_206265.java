// Load Driver
Driver driver = (Driver) session.load(Driver.class, driverId);

// Create Vehicle
Vehicle v = new Vehicle();
v.setDriver(driver);
v.setName("someName");

session.save(vehicle);
Thread1 (taking a snapshot)             Thread2 (updating locations)
                                        setLocation("truckA", 10, 10);
                                        setLocation("truckB", 20, 20);
p1 = getLocation("truckA") // (10, 10)
                                        setLocation("truckA", 5, 10);
                                        setLocation("truckB", 10, 10);
p2 = getLocation("truckB") // (10, 10)
assert !p1.equals(p2);     // fails
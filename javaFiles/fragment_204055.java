Car.CarPK pk1 = new Car.CarPK();
pk1.setChassisNumber(3);
pk1.setEngineNumber(2017);
Car.CarPK pk2 = new Car.CarPK();
pk2.setChassisNumber(1500);
pk2.setEngineNumber(520);

System.out.println(pk1.hashCode()); //prints 2020
System.out.println(pk2.hashCode()); //prints 2020

//Same hashCode, should be equal, just checking...
System.out.println(pk1.equals(pk2)); //prints false !
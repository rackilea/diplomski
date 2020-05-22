> Battery b = new Battery("Lithium ion", 5);
> SmartPhone s = new SmartPhone("Banana", "bPhone 2", b);
> s.getBattery().getVoltage()
5 (int)
> b.setVoltage(240); // danger! high voltage!
> s.getBattery().getVoltage()
240 (int)
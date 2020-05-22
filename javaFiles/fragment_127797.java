> Battery b = new Battery("Lithium ion", 5);
> SmartPhone s = new SmartPhone("Banana", "bPhone 2", b);
> b.setVoltage(240);
> s.getBattery().getVoltage()
5 (int)
> s.getBattery().setVoltage(240);
> s.getBattery().getVoltage()
5 (int)
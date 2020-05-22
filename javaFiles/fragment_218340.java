CaracteristicA caracteristicA = new CaracteristicA();
CaracteristicB caracteristicB = new CaracteristicB();
CaracteristicC caracteristicC = new CaracteristicC();
CaracteristicD caracteristicD = new CaracteristicD(); //hypothetic
client.addStatistic(new StatisticA(caracteristicA, caracteristicB));
client.addStatistic(new StatisticB(caracteristicC));
client.addStatistic(new StatisticC(caracteristicA, caracteristicD)); //hypothetic
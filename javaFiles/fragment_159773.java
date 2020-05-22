List<AtmTime> atmListIn = new ArrayList<AtmTime>();
List<AtmTime> atmListOut = new ArrayList<AtmTime>();
AtmTime atm = new AtmTime();

while(control !=6){
    control = Integer.parseInt(...);
    if(control == 2){
        date = atm.getDate();
        double moneyIn = Double.parseDouble(...);
        atm.setDate(date);
        atm.addFunds(moneyIn);
        atmListIn.add(atm);
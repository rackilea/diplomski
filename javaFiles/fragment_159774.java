List<AtmTime> atmListIn = new ArrayList<AtmTime>();
List<AtmTime> atmListOut = new ArrayList<AtmTime>();

while(control != 6) {
    control = Integer.parseInt(...);
    if(control == 2) {
        date = atm.getDate();
        double moneyIn = Double.parseDouble(...);
        AtmTime atm = new AtmTime(date, moneyIn);
        atmListIn.add(atm);
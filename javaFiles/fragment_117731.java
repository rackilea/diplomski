System.out.println("Enter the ID of the person you want to deposit into: ");
dep_id = input.nextDouble();
input.nextLine();

System.out.println("Enter your ID: ");
withdraw_id = input.nextDouble();
input.nextLine();

System.out.println(": ");
withdraw_amount = input.nextDouble();
input.nextLine();

PersonInfo fromPerson = null;
PersonInfo toPerson = null;

//find PersonInfo objects from list:
for (PersonInfo pi : info) {
    if (pi.getID() == dep_id) {
          toPerson = pi;
          break;
    }
}

for (PersonInfo pi : info) {
    if (pi.getID() == withdraw_id) {
          fromPerson = pi;
          break;
    }
}

if (fromPerson == null || toPerson == null) {
    System.out.println("Wrong IDs."); //maybe do something more user friendly here
    break;
}

if (withdraw_amount > fromPerson.getCredit()) {
    System.out.println("notify of error");
    break;
}

fromPerson.setCredit(fromPerson.getCredit() - withdraw_amount);
toPerson.setCredit(toPerson.getCredit() + withdraw_amount);

System.out.println("Done!\tTo print them out out choose option 2");
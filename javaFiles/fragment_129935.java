Person p = new Person();

Account ac1 = new Account();
ac1.setPerson(p);  
List<Account> acList = new ArrayList<>();
acList.add(ac1);

Address ad1 = new Adddress();
ad1.setPerson(p);
List<Address> adList = new ArrayList<>();
acList.add(ad1);
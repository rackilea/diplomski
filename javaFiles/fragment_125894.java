User u = new User();

Field field = u.getClass().getDeclaredField("account");
field.setAccessible(true);  

Account account = new Account();
account.amount = new Integer(1000);

field.set(u, account);
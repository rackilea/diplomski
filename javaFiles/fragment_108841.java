} else { //if not exceeding bank balance
                    balance -= (amount + Charge) ;  //subtract amount and charge from balance 
                    System.out.println("You have withdrawen £" + amount);
                    System.err.println("You now have a balance of £" + balance);
                    System.out.println("/");
                }
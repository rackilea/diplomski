int sum=0; // **new addition**
                for (countd = 0; countd < cupsOfCoffee; countd++)
                {
                    System.out.println("cup " + (countd + 1) + " has " + shots[countd] +  " shots and will cost" + (2+(shots[countd]))) ;
                    sum+=2+(shots[countd]); // **new addition**

                }
                System.out.println(cupsOfCoffee + "To purchase");
                System.out.println("Purchase price= " +sum ) ;// **new addition**
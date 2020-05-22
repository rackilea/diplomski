for (int i = 0; i < Newemp.length; i++) {
            if (Newemp[i].getPosition().equals("programmer")){
                programmers.add(Newemp[i]);
               System.out.println("programmers"+programmers);
            }
            else if (Newemp[i].getSalary()> 100000)
                    {
                        nonprogrammers.add(Newemp[i]);
                          System.out.println("salary 100000 thousand"+nonprogrammers);
                    }  else{
                        others.add(Newemp[i]);
                        System.out.println("others"+others);
                    }
        }
        for (int i = 0; i < programmers.size(); i++) {
            EmployeeData aa= programmers.get(i);
            System.out.println("All aaray"+aa);
        }
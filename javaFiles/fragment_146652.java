for (int k = 0; k < People.length; k++)
    for (int l = 0; l <People.length; l++)
    if (People[k].getsex() != People[l].getsex())
        if(Math.abs(People[k].getage()-People[l].getage()) <=5)
        {for(int m = 0; m < 5; m++)
            if((People[k].getinterest().charAt(m)=='1')  && (People[l].getinterest().charAt(m)=='1'));
                    count++;
                    if(count==3)
                        System.out.println(People[k].getName() + " is a match with " + People[l].getName());
        }
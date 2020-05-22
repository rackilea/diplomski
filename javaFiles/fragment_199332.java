public static int getHome()
{
    int homeNum;
    String home;
    do
    {
        home = JOptionPane.showInputDialog(null,"Enter 1(apartment), 2(house),"
            + " or 3(dorm).","Dwelling Type", JOptionPane.QUESTION_MESSAGE);
        homeNum = Integer.parseInt(home);

        if(!(homeNum == 1) && !(homeNum == 2) && !(homeNum == 3))
        {    
            JOptionPane.showMessageDialog(null, "The value for dwelling type "
                + "must be 1(apartment), 2(house), or 3(dorm)", "Dwelling"
                        + "Type Error", JOptionPane.ERROR_MESSAGE);

        }              
    }
    while(homeNum < 0 || homeNum > 3);
    return homeNum;    
}
public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int month;
    int day;
    String season= "seasons";


    System.out.print("type a two digit month");
    System.out.print(" and day");
    month = in.nextInt();
    day = in.nextInt();


    String winter = " winter ";
    String summer = " summer";
    String spring = " spring";
    String fall = " fall";

    System.out.print(" Month="+ month +" Day= "+day);

    if (month <= 3)
    {
        //System.out.println(" Winter");
        season = winter;
    }
    else if (month <= 6)
    {
        //System.out.println(" Spring ");
        season = spring;
    }
    else if (month <= 9)
    {
        //System.out.println(" Summer ");
        season = summer;
    }
    else if (month <= 12)
    {
        //System.out.println(" Fall");
        summer = fall;
    }


    if (month % 3 == 0 && day >= 21) {

        if ( season.equals(winter) )  
            season = spring;
             //System.out.println(" Spring");

        else if ( season.equals(spring) ) 
            season = summer;
            //System.out.println ( "Summer" );

        else if ( season.equals(summer) ) 
            season = fall;
            //System.out.println ( " Fall");

        else if ( season.equals(winter) ) 
            season = winter;
            //System.out.println( " winter");
    }   

    System.out.println(season);
}
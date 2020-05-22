import com.joestelmach.natty.*;

List<Date> dates =new Parser().parse("Start date 11/30/2013 , end date Friday, Sept. 7, 2013").get(0).getDates();
        System.out.println(dates.get(0));
        System.out.println(dates.get(1));

//output:
//Sat Nov 30 11:14:30 BDT 2013
//Sat Sep 07 11:14:30 BDT 2013
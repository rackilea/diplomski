All type of cron exrpession you build from website [Cron Maker] 
I have one solution to meet with your requirement:
Algorithm:
1. Run cron every MON and WED day.


    eg. 0 0 12 ? * MON,WED * 
       Start time   Monday, September 7, 2015 6:10 AM Change
       Next 5 scheduled dates   
       a.   Monday, September 7, 2015 12:00 PM
       b.   Wednesday, September 9, 2015 12:00 PM
       c.   Monday, September 14, 2015 12:00 PM
       d.   Wednesday, September 16, 2015 12:00 PM
       e.   Monday, September 21, 2015 12:00 PM

2. Now pro-grammatically control on odd week. for eg in java


    Calendar c = Calendar.getInstance();
       if(c.get(Calendar.WEEK_OF_MONTH) % 2 != 0) {
             //execute job
       } else {
             //not execute job just skip operation
       }
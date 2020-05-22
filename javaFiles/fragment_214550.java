package com.example;

import java.util.Calendar;

public class DeitelDate {
    int year;
    int month;
    int day;

    public int getYear()
     {
        return year;
      }
      public int getMonth()
     {
        return month;
      }
      public int getDay()
      {
        return day;
      }
      // return a String of the form month/day/year
        public int findAge()
       {
        return  Calendar.getInstance().get(Calendar.YEAR)-year;

        }

        public String ageToString()
        {
        return String.format("Patient age:",findAge());
        }
       public String toString()
       { 
        return String.format( "%d/%d/%d",month,day,year); 
       } // end method toString

       public static void main(String[] args){
           DeitelDate d = new DeitelDate();
           d.year = 1979;
           System.out.println(d.findAge());
       }
}
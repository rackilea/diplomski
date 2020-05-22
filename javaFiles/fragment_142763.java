public class Basic {

    public static String addTimeTo(int year, int month, int day, int hour, int timeToAdd) {
        // Perform calculations...
        // return result...
    }

//  static int year = displayFrame.yearsIn;
//  static int month = displayFrame.monthsIn;
//  static int day = displayFrame.daysIn;
//  static int hour = displayFrame.hrsIn;
//
//  public static String output;
//
//  double yearD = year;
//  double leapYear = yearD / 4;
//  int daysInMonth = 0;
//  int daysInYear = 365;
//  int casePick = 0;
//  int hoursAdded = 0;
//  int x = 0;
//
//  {
//
//      //Making sure that the number added isn't negative, ones for other inputs MAY come...
//      while (x == 0) {
//          if (Math.abs(hoursAdded) != hoursAdded) {
//              continue;
//          } else {
//              x++;
//          }
//
//          /*Starts the counting loop and for each month value, it will determine how many days are in it
//           this will allow for exact measurement.*/
//          while (hoursAdded > 0) {
//              switch (month) {
//                  case 1:
//                      daysInMonth = 31;
//                      break;
//                  case 2:
//                      if (leapYear % 1 == 0) {
//                          daysInYear = 366;
//                          daysInMonth = 29;
//                      } else {
//                          daysInMonth = 28;
//                      }
//                      break;
//                  case 3:
//                      daysInMonth = 31;
//                      break;
//                  case 4:
//                      daysInMonth = 30;
//                      break;
//                  case 5:
//                      daysInMonth = 31;
//                      break;
//                  case 6:
//                      daysInMonth = 30;
//                      break;
//                  case 7:
//                      daysInMonth = 31;
//                      break;
//                  case 8:
//                      daysInMonth = 31;
//                      break;
//                  case 9:
//                      daysInMonth = 30;
//                      break;
//                  case 10:
//                      daysInMonth = 31;
//                      break;
//                  case 11:
//                      daysInMonth = 30;
//                      break;
//                  case 12:
//                      daysInMonth = 31;
//                      break;
//              }
//
//
//              /*Decides whether a year, month, day or hour is left, adds one to its counter,
//               and then takes away that amount of time from the hours added that are left*/
//              if (hoursAdded >= daysInYear * 24) {
//                  hoursAdded = hoursAdded - (daysInYear * 24);
//                  year++;
//                  break;
//              }
//
//              if (hoursAdded >= daysInMonth * 24 && hoursAdded < daysInYear * 24) {
//                  hoursAdded = hoursAdded - (daysInMonth * 24);
//                  month++;
//                  break;
//              }
//
//              if (hoursAdded >= 24 && hoursAdded < daysInMonth * 24) {
//                  hoursAdded = hoursAdded - 24;
//                  day++;
//                  break;
//              }
//
//              if (hoursAdded >= 1 && hoursAdded < 24) {
//                  hoursAdded = hoursAdded - 1;
//                  hour++;
//                  break;
//              }
//
//              //Makes sure there are never 25 hours, 32 days or 13 months
//              if (hour > 24) {
//                  day++;
//                  hour = 1;
//              }
//
//              if (day > daysInMonth) {
//                  month++;
//                  day = 1;
//              }
//
//              if (month > 12) {
//                  year++;
//                  month = 1;
//              }
//          }
//          output = "hello";
//          /*hello is a test value, this will be the actual value: 
//           ("The date you have requested is: " + month + "/" + day + "/" + year + " Hour:" + hour);*/
//      }
//  }
}
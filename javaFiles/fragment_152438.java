package com.stackoverflow.works;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author sarath_sivan
 */

public class DateFormatHelper {

    private static final String DD_MM_YYYY = "MMddyyyy";
    private static final String DD_SLASH_MM_SLASH_YYYY = "MM/dd/yyyy";


    public static void main(String[] args) {
        DateFormatHelper  dateFormatHelper = new DateFormatHelper();
        dateFormatHelper.run();
    }

    public void run() {
        String strDate = "Available on 03292013";
        System.out.println("Input Date: " + strDate);
        strDate = DateFormatHelper.getDate(strDate); 
        strDate = "Available on " + DateFormatHelper.formatDate(strDate);
        System.out.println("Formatted Date: " + strDate);
    }

    public static String formatDate(String strDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DD_MM_YYYY);
        Date date;
        try {   
            date = simpleDateFormat.parse(strDate);
            simpleDateFormat = new SimpleDateFormat(DD_SLASH_MM_SLASH_YYYY);
            strDate = simpleDateFormat.format(date);
         } catch (ParseException parseException) {
             parseException.printStackTrace();
         }

        return strDate;
    }

    public static String getDate(String strDate) {
        return strDate.replaceAll("[^0-9]", "");
    }

}
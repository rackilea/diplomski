package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.ibm.icu.util.Calendar;
import com.ibm.icu.util.GregorianCalendar;
import com.mPower.fw.dao.ClassMaster;
import com.mPower.fw.impl.DaoServiceIMPL;
import com.mPower.fw.util.hibernateUtil;

public class runT {

    public static void main(String[] args) throws IOException {
        try{
            Calendar calendar = new GregorianCalendar();
            int CURRENT_MONTH = 0;
            int MONTH_BACK = 5;

            int totalDays = 0;

        calendar.set(Calendar.MONTH, CURRENT_MONTH);

            for(int i=0;i<MONTH_BACK;i++){
                totalDays += calendar.getMaximum(java.util.Calendar.DAY_OF_MONTH);
                calendar.add(Calendar.MONTH, -1);
            }

            System.out.println(totalDays);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
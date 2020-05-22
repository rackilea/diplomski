package com.asela.util;

import java.lang.reflect.Field;
import java.sql.Date;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.Objects;

import org.h2.expression.Function;

public class H2Function {

    @SuppressWarnings("rawtypes")
    public static int removeDateDifference() {
        try {
              Field field = Function.class.getDeclaredField("FUNCTIONS");
              field.setAccessible(true);
              ((Map)field.get(null)).remove("DATEDIFF");
        } catch (Exception e) {
            throw new RuntimeException("failed to remove date-difference");
        }
        return 0;
    }

    public static long dateDifference(Date date1, Date date2) {
        Objects.nonNull(date1);
        Objects.nonNull(date2);
        return ChronoUnit.DAYS.between(date1.toLocalDate(), date2.toLocalDate());
    }
}
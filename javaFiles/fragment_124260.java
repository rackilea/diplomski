package test;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;

    public class Java8PeriodAndInstant2 {

        public static void main(String[] args) {
            // LocalDate request=LocalDate.of(2000, 5, 2);
            // LocalDate start=LocalDate.of(2000, 1, 1);
            LocalDateTime start = Instant.parse("2000-01-01T06:00:00.000Z").atZone(ZoneId.of("UTC")).toLocalDateTime();
            LocalDateTime request = Instant.parse("2000-05-02T07:42:00.000Z").atZone(ZoneId.of("UTC")).toLocalDateTime();
            Period period = Period.ofMonths(3);
            System.out.println("is on grid " + isOnGrid(request, start, period));
            System.out.println("is on grid " + isOnGrid(LocalDateTime.of(2000, 4, 2,0,0), start, period));
            System.out.println("is on grid " + isOnGrid(LocalDateTime.of(2000, 4, 1,0,0), start, period));
            System.out.println("getNextPriorDate " + getNextPriorDate(request, start, period));
            System.out.println("isOnGrid " + isOnGrid(Instant.parse("2000-01-03T05:00:00.000Z").atZone(ZoneId.of("UTC")).toLocalDateTime(), start, Period.ofDays(1)));
            System.out.println("isOnGrid " + isOnGrid(Instant.parse("2000-01-03T06:00:00.000Z").atZone(ZoneId.of("UTC")).toLocalDateTime(), start, Period.ofDays(1)));
            System.out.println("getNextPriorDate " + getNextPriorDate(Instant.parse("2000-01-03T05:00:00.000Z").atZone(ZoneId.of("UTC")).toLocalDateTime(), start, Period.ofDays(1)));
        }

        private static boolean isOnGrid(LocalDateTime start, LocalDateTime request, Period period) {
            if (period.getDays() != 0) {
                return ((Duration.between(start, request).toHours()%period.getDays())==0);
            }
            Period diffPeriod = Period.between(start.toLocalDate(), request.toLocalDate());
            if (diffPeriod.getDays()!=0) {
                return false;
            }
            if (period.getMonths() != 0) {
                return ((diffPeriod.toTotalMonths()) % (period.toTotalMonths()) == 0);
            }
            if (diffPeriod.getMonths()!=0) {
                return false;
            }               
            if (period.getYears() != 0) {
                return ((diffPeriod.getYears()) % (period.getYears()) == 0);
            }   
            return false;
        }

        private static LocalDateTime getNextPriorDate(LocalDateTime request, LocalDateTime start, Period period) {
            if (period.getDays() != 0) {
                long hoursDiff=Duration.between(start, request).toHours();
                return start.plusDays(hoursDiff/24);
            }
            Period diffPeriod = Period.between(start.toLocalDate(), request.toLocalDate());
            if (period.getMonths() != 0) {
                diffPeriod = diffPeriod.withDays(0);
                long monthDiff = diffPeriod.toTotalMonths() % period.toTotalMonths();
                return start.plus(diffPeriod).minusMonths(monthDiff);
            }
            if (period.getYears() != 0) {
                diffPeriod = diffPeriod.withDays(0);
                diffPeriod.withMonths(0);
                long yearsDiff = diffPeriod.getYears() % period.getYears();
                return start.plus(diffPeriod).minusYears(yearsDiff);
            }               
            return null;
        }

    }
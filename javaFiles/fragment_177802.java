import java.util.Date;
import java.util.Random;


class MyTime {

    int years;
    int months;
    int day;
    int hours;
    int seconds;

    public MyTime(long inputSeconds) {
        Date d = new Date(inputSeconds);
        this.years = d.getYear();
        this.months = d.getMonth();
        this.day = d.getDay();
        this.hours = d.getHours();
        this.seconds = d.getSeconds();
    }

    public static void main(String[] args) {
        new MyTime(new Date().getTime()).show();
    }

    public void show() {
        System.out.println("" + years + "");
        System.out.println("" + months + "");
        System.out.println("" + day + "");
        System.out.println("" + hours + "");
        System.out.println("" + seconds + "");
    }

}
static class TimePart {
    int days = 0;
    int hours = 0;
    int minutes = 0;
    int seconds = 0;

    static TimePart parse(String in) {
        if (in != null) {
            String[] arr = in.split(":");
            TimePart tp = new TimePart();
            tp.days = ((arr.length >= 1) ? Integer.parseInt(arr[0]) : 0);
            tp.hours = ((arr.length >= 2) ? Integer.parseInt(arr[1]) : 0);
            tp.minutes = ((arr.length >= 3) ? Integer.parseInt(arr[2]) : 0);
            tp.seconds = ((arr.length >= 4) ? Integer.parseInt(arr[3]) : 0);
            return tp;
        }
        return null;
    }

    public TimePart add(TimePart a) {
        this.seconds += a.seconds;
        int of = 0;
        while (this.seconds >= 60) {
            of++;
            this.seconds -= 60;
        }
        this.minutes += a.minutes + of;
        of = 0;
        while (this.minutes >= 60) {
            of++;
            this.minutes -= 60;
        }
        this.hours += a.hours + of;
        of = 0;
        while (this.hours >= 24) {
            of++;
            this.hours -= 24;
        }
        this.days += a.days + of;
        return this;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d:%02d", days, hours, minutes,
                seconds);
    }
}
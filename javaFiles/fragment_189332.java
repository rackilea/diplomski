public float toMinutes(char type, String value) {
    switch (type) {
        case 'd':
            return Integer.parseInt(value) * TimeUnit.DAYS.toMinutes(1);
        case 'h':
            return Float.parseFloat(value) * TimeUnit.HOURS.toMinutes(1);
        case 'm':
            return Integer.parseInt(value);
        default:
            return 0;
    }
}
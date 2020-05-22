public InputData() {
        this.c = Calendar.getInstance();
        this.today = new Date();
        today = c.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        System.out.println(sdf.format(today));
    }
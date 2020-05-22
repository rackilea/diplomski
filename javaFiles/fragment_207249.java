public static void main(String[] args) {
        Date todayDate = new Date();
        Timestamp original = new Timestamp(todayDate.getTime());
        Calendar c = Calendar.getInstance();

        System.out.println("Old time : " + original.toString());

        c.setTimeInMillis(original.getTime());

        int daysToAdd = 5;

        switch (daysToAdd) {
        case 1:
            c.add(Calendar.DAY_OF_YEAR, 7);
            break;
        case 2:
            c.add(Calendar.DAY_OF_YEAR, 14);
            break;
        case 3:
            c.add(Calendar.DAY_OF_YEAR, 21);
            break;
        case 4:
            c.add(Calendar.DAY_OF_YEAR, 30);
            break;
        case 5:
            c.add(Calendar.DAY_OF_YEAR, 60);
            break;
        case 6:
            c.add(Calendar.DAY_OF_YEAR, 90);
            break;
        case 7:
            c.add(Calendar.DAY_OF_YEAR, 180);
            break;
        default:
            c.add(Calendar.DAY_OF_YEAR, 7);
        }

        Timestamp later = new Timestamp(c.getTime().getTime());
        System.out.println("New time : " + later.toString());
    }
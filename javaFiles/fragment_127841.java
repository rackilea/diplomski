try {
        dateFormat.setLenient(false);
        dateFormat.parse(date);
        return true;
    } catch (ParseException e) {
        e.printStackTrace();
        return false;
    }
DateTime dateTimeDOB = ...

    int day = dateTimeDOB.getDay();
    int month = dateTimeDOB.getMonth() + 1;
    int year = dateTimeDOB.getYear();

    String strDate = (day < 10) ? "0" + day + "/" : day + "/";
    strDate += (month < 10) ? "0" + month + "/" : month + "/";
    strDate += year;
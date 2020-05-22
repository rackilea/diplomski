long date2l = Timestamp.valueOf("2012-05-03 05:30:10").getTime();
long date1l = Timestamp.valueOf("2012-01-19 00:00:00").getTime();
long diffms = date2l - date1l; //difference in ms
long diff_seconds = diffms / 1000; //total difference in seconds
long diff_mins = diff_seconds / 60; //total difference in minutes
long diff_hours = diff_mins / 60; //total difference in hours
long diff_days = diff_hours / 24; //total difference in days

long x = (diff_seconds - diff_days * 60 * 60 * 24) / (60 * 60);
long y = ((diff_seconds - (diff_hours * 60 * 60))) / 60;
long z = ((diff_seconds - (diff_mins * 60)));
long w = diff_days;

System.out.println(w + " " + x + " " + y + " " + z);
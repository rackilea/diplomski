import java.util.Calendar;

switch (Calendar.getInstance().get(Calendar.DAY_OF_WEEK)) {
    case Calendar.WEDNESDAY:
        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        if (hour >= 18 && hour <= 20) {
            Intent intendedActivity = new Intent(this, IntendedActivity.class);
            startActivity(intendedActivity);
        }

}
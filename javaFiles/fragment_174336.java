Calendar now = Calendar.getInstance();
int currentHour = now.get(Calendar.HOUR_OF_DAY);
if(currentHour >=7 && currentHour <= 11)
    rootLayoutReference.setVisibility(View.GONE);
else
    rootLayoutReference.setVisibility(View.VISIBLE);
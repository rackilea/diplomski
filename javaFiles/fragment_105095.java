private int getBest(){
    //Getting dates
    ArrayList<Date> successDates = new ArrayList<>();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    for(int i=0; i<successDays.size(); i++){
        try {
            successDates.add(sdf.parse(successDays.get(i)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    int max_len = 1;
    for(int i=0; i<successDates.size(); i++){
        Date mn = successDates.get(i);
        Date mx = successDates.get(i);
        for(int j=i+1; j<successDates.size(); j++){
            if(mn.compareTo(successDates.get(j))>0){
                mn = successDates.get(j);
            }
            if(mx.compareTo(successDates.get(j))<0){
                mx = successDates.get(j);
            }
            if(getDaysBetweenDates(mn, mx) == j-i){
                if(max_len < getDaysBetweenDates(mn, mx)+1){
                    max_len = getDaysBetweenDates(mn, mx) + 1;
                }
            }
        }
    }
    return max_len;
}

private int getDaysBetweenDates(Date min, Date max){
    Calendar mn = Calendar.getInstance();
    mn.setTime(min);

    Calendar mx = Calendar.getInstance();
    mx.setTime(max);

    long msDiff = mx.getTimeInMillis() - mn.getTimeInMillis();
    return (int)TimeUnit.MILLISECONDS.toDays(msDiff);
}
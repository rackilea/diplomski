public static String concateDays(List<String> days) {

    StringBuffer result = new StringBuffer(days.get(0));
    int previousIndex = DAY.valueOf(days.get(0)).getValue();
    int length = days.size();

    for (int i=1; i< days.size(); i++) {
        String day = days.get(i);
        if(previousIndex + 1 == DAY.valueOf(day).getValue()){
            if(i == length -1 || DAY.valueOf(day).getValue() + 1 != DAY.valueOf(days.get(i+1)).getValue()){
                result.append(" - ");
                result.append(day);
            }
        }else{
            result.append(", ");
            result.append(day);
        }
        previousIndex = DAY.valueOf(day).getValue();
    }
    return result.toString();
}
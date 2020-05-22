public static void main(String []args) {
    System.out.println(System.currentTimeMillis());
    System.out.println(new Date());
    Map<TimeUnit,Long> result = computeDiff(
            new Date("7/20/2016"),
        new Date("8/20/2016")
    );
    System.out.println(result);
 }

public static Map<TimeUnit,Long> computeDiff(Date date1, Date date2) {

    long diffInMillies = date2.getTime() - date1.getTime();
    List<TimeUnit> units = new ArrayList<TimeUnit>(EnumSet.allOf(TimeUnit.class));
    Collections.reverse(units);

    Map<TimeUnit,Long> result = new LinkedHashMap<TimeUnit,Long>();
    long milliesRest = diffInMillies;
    for ( TimeUnit unit : units ) {
        long diff = unit.convert(milliesRest,TimeUnit.MILLISECONDS);
        long diffInMilliesForUnit = unit.toMillis(diff);
        milliesRest = milliesRest - diffInMilliesForUnit;
        result.put(unit,diff);
    }
    return result;
}
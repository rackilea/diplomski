@Override
public int compare(Dto r1, Dto r2) {

    int value = Integer.compare(r1.getOrder(), r2.getOrder());
    if (value != 0)
        return value;
    Date date1 = r1.getDate();
    Date date2 = r2.getDate();
    if (date1 == null && date2 == null)
        return 0;
    if (date1 == null)
        return -1;
    if (date2 == null)
        return 1;
    return date1.compareTo(date2);
}
...
    Iterator<LimitOrder> i = a.iterator();
    while (i.hasNext()) {
        LimitOrder l = i.next();
        if (isMatch(l)) {
            i.remove();
            System.out.println("Removed " + l.orderID);
        }
    }
    ...

public static boolean isMatch(LimitOrder l) {
    return l.orderID.equals("542");
}
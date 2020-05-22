class Mean {

    static int total = 0;
    static int count = 0;

    public static double mean (Cons lst) {
        total += (Integer) lst.data;
        count += 1;
        if(lst.next == null) {
            double ret = total/count;
            total = 0;
            count = 0;
            return ret;
        }
      return mean(lst.next); // return statement isn't correct, need help here as well
    }
}
public static double mean (Cons lst) {
    return recursiveMean (lst, 0, 0)
}

public static double recursiveMean (Cons lst, int count, int total) {
    total += (Integer) lst.data;
    count += 1;
    if(lst.next == null) {
        return total / count;
    }
  return mean(lst.next,count,total); // return statement isn't correct, need help here as well
}
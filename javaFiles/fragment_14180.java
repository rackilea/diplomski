public static void main(String[] args) throws Exception {
    double pos = 0.0;
    System.out.println("" + (pos == 0.0)); // true
    double neg = -0.0;
    System.out.println("" + (neg == 0.0)); // true
    System.out.println("" + (neg == pos)); // true
    HashSet<Double> set = new HashSet<Double>();
    set.add(pos);
    set.add(neg);
    System.out.println("" + set.size()); // 2
}
class AgeComparator implements Comparator<UserDetails> {
    @Override
    public int compare(UserDetails o1, UserDetails o2) {
         return o1.age - o2.age;
    }
}
public static void main(String[] args) {
    Type t = Wall.BOTTOM;
    System.out.println(t instanceof Wall);
    System.out.println(((Wall)t) == Wall.BOTTOM);

    t = Floor.TOP_LEFT;
    System.out.println(t instanceof Floor);
    System.out.println(((Floor)t) == Floor.TOP_LEFT);
}
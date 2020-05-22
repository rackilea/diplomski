String[][] stateInfo = new String[][]{
                        {"Alabama", "1900", "Birmingham", "Wide-Awake", "1"},
                        {"Illinois", "1900", "Blakeley", "Blakeley Sun", "10"}};
for (String[] si: stateInfo){
    String s = String.format("%1$-12s %2$-5s %3$-12s %4$-12s %5$-2s ",
                                    si[0],si[1],si[2],si[3],si[4]);
    System.out.println("String:"+s);
}
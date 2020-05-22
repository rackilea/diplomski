int[] ints = new int[] { 76543, 65334, 776958, 8978, 2436, 232789 };
for (int i : ints) {
    boolean containsAllThree = false;
    if (String.valueOf(i).contains("7") && String.valueOf(i).contains("8") && String.valueOf(i).contains("9"))
        containsAllThree = true;
    System.out.println(containsAllThree);
}
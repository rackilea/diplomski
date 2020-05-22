private static Integer[][] myarray = new Integer[5][5];

public static boolean exists(int row, int value) {
    if(row >= myarray.length) return false;
    List<Integer> rowvalues = Arrays.asList(Arrays.asList(myarray).get(row));
    if(rowvalues.contains(value)) return true;
    return exists(row+1, value);
}
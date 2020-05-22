Arrays.sort(data, new Comparator<String[]>() { // sort the array
    SimpleDateFormat f = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z");
    // SimpleDateFormat  to parse the String Date
    @Override
    public int compare(String[] o1, String[] o2) {
        try {
            return f.parse(o1[2]).compareTo(f.parse(o2[2]));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }
});
for(int i = 0; i < data.length; i++){ // display the result
    for(int j = 0; j < data[i].length; j++)
    {
        System.out.print(data[i][j]);
        if(j < data[i].length - 1) System.out.print(" ");
    }
    System.out.println();
}
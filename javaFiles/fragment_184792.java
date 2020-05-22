final BufferedReader br =
    new BufferedReader(new FileReader("/this/is/the/path/to/the/file.txt"));
final int[] mins = { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE,
                     Integer.MAX_VALUE, Integer.MAX_VALUE };
final int[] maxes = { Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE,
                      Integer.MIN_VALUE, Integer.MIN_VALUE };
final double[] sums = { 0.0, 0.0, 0.0, 0.0, 0.0 };
int count = 0;
try {
    String line;
    while((line = br.readLine()) != null) {
        ++count;
        final String[] values = line.split("\\s+");
        for(int i = 0; i < 5; ++i) {
            final int value = Integer.parseInt(values);
            if(value < mins[i]) {
                mins[i] = value;
            }
            if(value > maxes[i]) {
                maxes[i] = value;
            }
            sums[i] += value;
        }
    }
} finally {
    br.close();
}
final double[] averages = new double[sums.length];
for(int i = 0; i < sums.length; ++i) {
    averages = sums[i] / count; 
}
System.out.println(Arrays.toString(mins));
System.out.println(Arrays.toString(maxes));
System.out.println(Arrays.toString(averages));
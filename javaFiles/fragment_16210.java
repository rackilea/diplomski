int[][] iArr = Arrays.stream(s.split("\n")).map(r
        -> // It transforms a String 'r' into a int[]
        Arrays.stream(r.split("\t")).mapToInt(Integer::parseInt).toArray()
// It transforms a Stream of int[] into int [][]
).toArray(int[][]::new);

System.out.println(Arrays.deepToString(iArr));//Print your result
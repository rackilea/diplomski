Integer[] arr = { null, null, 5, 111, 21, null, 22, null, null, null,
        98, 25, 47, null, 1, 23, null };

Integer[] newarr = new Integer[arr.length];

for (int i = 0; i < arr.length; i++)
    fill(newarr, arr, i);

System.out.println(Arrays.toString(newarr));
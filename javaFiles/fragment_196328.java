String[] data = new String[2];
System.out.println(Arrays.toString(data)+" - "+Arrays.deepHashCode(data));
data[0] = "abc";
System.out.println(Arrays.toString(data)+" - "+Arrays.deepHashCode(data));
data[1] = "def";
System.out.println(Arrays.toString(data)+" - "+Arrays.deepHashCode(data));
String[] data = new String[2];
System.out.println(Arrays.toString(data)+" - "+data.hashCode());
data[0] = "abc";
System.out.println(Arrays.toString(data)+" - "+data.hashCode());
data[1] = "def";
System.out.println(Arrays.toString(data)+" - "+data.hashCode());
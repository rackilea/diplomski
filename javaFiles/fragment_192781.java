List< String > arrayList = Arrays.asList("Folder3", "Folder1", "Folder2");

File parent = new File("/path");
File[] arr = new File[arrayList.size()];

for ( int i = 0; i < arr.length; i++ )
    arr[i] = new File(parent, arrayList.get(i));

// Now arr will contain File objects in the order they are listed in arrayList
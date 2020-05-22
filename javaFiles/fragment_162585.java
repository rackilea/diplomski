int arr[] = {10,3,34,3,10};

HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
for (int i = 0; i < arr.length; i++) {
     hmap.put(arr[i],1);
}

hmap.forEach((k, v) -> System.out.println("key = " + k + " value = " + v));
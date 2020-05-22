ArrayList<int[]> values = new ArrayList<int[]>();

values.add(new int[]{1,2});
values.add(new int[]{1,3});

HashMap<String, List<int[]>> H = new HashMap<String, List<int[]>>(); 

H.put("drdetroit", values);

for(String key : H.keySet()) {
    for(int[] array : H.get(key)){
        System.out.println(Arrays.toString(array));
    }
}
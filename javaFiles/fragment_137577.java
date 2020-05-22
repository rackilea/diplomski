class LeadersInArray {
    List<Integer> printLeaders(int[] arr, int size) {
        List<Integer> list = new ArrayList<>();

        int max_from_right = arr[size - 1];

        list.add(max_from_right);


        for (int i = size - 1; i >= 0; i--) {
            if (max_from_right < arr[i]) {
                max_from_right = arr[i];
                list.add(max_from_right);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        LeadersInArray lead = new LeadersInArray();
        int arr[] = new int[]{16, 17, 4, 3, 5, 2};
        List<Integer> integers = lead.printLeaders(arr, arr.length);
        for(int i = integers.size()-1; i>=0 ;i--){
            System.out.println(integers.get(i));
        }

    }
}
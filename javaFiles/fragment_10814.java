public class Registry {
    private ArrayList<Integer> nums = new ArrayList<Integer>();
    public void addNum(int num) {
        this.nums.add(num);
        System.out.println("Size of array: " + this.nums.size());

        for (int n: nums){
            System.out.println("Element of the array: " + n);
        }
    }
}
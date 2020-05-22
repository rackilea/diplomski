class IntWrapper {
    public int value;
    public IntWrapper(int i) {
       value = i;
    }
}

class Main{
public static void main(String[] args) { 
   IntWrapper num1 = new IntWrapper(1);
   IntWrapper num2 = new IntWrapper(2);
   IntWrapper num3 = new IntWrapper(3);

   IntWrapper[] nums = {num1, num2, num3};
   num1.value++; 
   System.out.println(num1.value);
   System.out.println(nums[0].value);
}
}
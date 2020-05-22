static void f(int... nums) {
    for (int num : nums) {
        System.out.println(num);
    }
}
//...

f(1,2,3); // prints "1", "2", "3"
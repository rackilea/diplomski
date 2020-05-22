public class Solution {

    public static void main(String[] args) {
        //create two object of every class here
        Solution solution = new Solution();
        Man m1 = solution.createMan("a1", "b1", 11);
        Man m2 = solution.createMan( "a2", "b2", 12);

        //output them to screen here
        System.out.println(m1.name + " " + m1.age + " " + m1.address);
        System.out.println(m2.name + " " + m2.age + " " + m2.address);    
    }

    Man createMan(String name, String address, int age) {
        return new Man(name, address, age);
    }

    //add your classes here
    public class Man {
        private String name;
        private String address;
        private int age;

        private Man(String name, String address, int age) {
            this.name = name;
            this.address = address;
            this.age = age;
        }
    }
}
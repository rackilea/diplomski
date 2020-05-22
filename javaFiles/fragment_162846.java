class Test implements Compareable<Test>{
    ...
    @Override
    public int compareTo(Test test) {
        // write logic for compare 
        //a negative integer, zero, or a positive integer as 
        //this object is less than, equal to, or greater than the specified object
        return 0;
    }
}

class Main{
    public static void main(String[] args){
        Test x1 = new Test(9999,9999);
        Test x2 = new Test(0,0);
        int x3 = x1.compareTo(x2);
    }
}
public boolean overloadable(String b) {
       //....
        return false;
    }

    public boolean overloadable(Object a){
      //...
            return true;
    }

    public static void main(String[] args) {
        Sample sample = new Sample();
        System.out.println(sample.overloadable(12));//call Object arguement method
        System.out.println(sample.overloadable("12"));
    }
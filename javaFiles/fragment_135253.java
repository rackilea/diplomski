class X {

    int z = 2;

}

class Y extends X {
}

class A extends Y {

    public static void main(String[] args) {
        System.out.println(new A().z);
    }
}
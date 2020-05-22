public void test() {
        Integer[] a = new Integer[3];
        for(int i=0; i<a.length; i++) {
            if(a[i] != null) { //should now compile
                System.out.println('null!');
            }
        }
    }
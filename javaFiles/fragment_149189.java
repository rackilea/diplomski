class Test2 {

    public static class MutableInteger {
        public Integer value;
        public MutableInteger(Integer value) {
            this.value = value;
        }
    }

    MutableInteger getInt() {
        MutableInteger returnVal = new MutableInteger(10);
        try {
            throw new Exception();
        }
        catch(Exception e) {
            return returnVal;
        }
        finally {
            returnVal.value += 10;
        }
    }

    public static void main(String[] args) {    
        Test2 test = new Test2();
        System.out.println(test.getInt().value);
    }
}
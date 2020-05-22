class BaseClass {
    private int field1 = 0;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BaseClass) {
            return field1 == ((BaseClass) obj).field1;
        }
        return false;
    }
}

class BadSubClass extends BaseClass {
    private int field2 = 0;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BadSubClass) {
            return super.equals(obj) 
                    && field2 == ((BadSubClass) obj).field2;
        }
        return false;
    }
}
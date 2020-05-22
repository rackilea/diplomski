class BaseClass {
    private int field1 = 0;

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            return field1 == ((BaseClass) obj).field1;
        }
        return false;
    }
}

class GoodSubClass extends BaseClass {
    private int field2 = 0;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof GoodSubClass) {
            return super.equals(obj) && field2 == ((GoodSubClass) obj).field2;
        }
        return false;
    }
}
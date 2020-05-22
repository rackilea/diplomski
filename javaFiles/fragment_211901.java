interface Gift {
    boolean hasWarranty();
}

class Computer implements Gift {
    private boolean warranty;

    @Override
    public boolean hasWarranty() {
        return warranty;
    }
}

class GreetingCard implements Gift {
    @Override
    public boolean hasWarranty() {
        return false;
    }
}
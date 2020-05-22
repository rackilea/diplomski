class MultipleStringparameters extends Multipletypeparameters<String, String> {

    @Override
    public String add() {
        return this.obj1 + this.obj2;
    }
}

class MultipleIntegerparameters extends Multipletypeparameters<Integer, Integer> {

    @Override
    public Integer add() {
        return this.obj1 + this.obj2;
    }
}
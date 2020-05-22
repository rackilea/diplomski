interface MyArray<A extends MyArray<A>> {
    A clone();
}

interface MyVector<A extends MyVector<A>> extends MyArray<A> {

}

class MyDoubleVector implements MyVector<MyDoubleVector> {
    //...
    @Override
    public MyDoubleVector clone(){
        //...
        return new MyDoubleVector(Arrays.copyOf(data));
    }
}
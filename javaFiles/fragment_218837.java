public static class MyModel {
    private PublishSubject<MyModel> changeObservable = PublishSubject.create();
    private String field1;

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
        changeObservable.onNext(this);
    }

    public Observable<MyModel> getModelChanges() {
        return changeObservable;
    }

    @Override
    public String toString() {
        return "MyModel{" +
                "field1='" + field1 + '\'' +
                '}';
    }
}


public static void main(String[] args) {
    MyModel myModel = new MyModel();
    myModel.getModelChanges()
            .subscribe(System.out::println);

    myModel.setField1("1");
    myModel.setField1("2");
    myModel.setField1("3");
}
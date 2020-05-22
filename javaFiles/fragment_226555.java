class FooData extends Data<FooData, FooMsg> {
}

class FooMsg extends Msg<FooMsg, FooData> {
    @Override FooData createData() {
        return new FooData();
    }
}
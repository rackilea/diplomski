public static class SingleUserReducer extends
        Reducer<Text, CountInformationTuple, Text, CountInformationTuple> {

    private CountInformationTuple result = new CountInformationTuple();
    private int login = 0;
    private int order = 0;

    public void reduce(Text key, Iterable<CountInformationTuple> values,
            Context context) throws IOException, InterruptedException {

        for (CountInformationTuple val : values) {
            login += val.getCountLogin();
            order += val.getCountOrder();
        }
    }

    public void cleanup(Context context) throws IOException, InterruptedException {
        result.setCountLogin(login);
        result.setCountOrder(order);

        context.write(new Text("total"), result);
    }
}
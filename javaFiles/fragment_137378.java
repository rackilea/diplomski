@Override
protected Void doInBackground() throws Exception {
    int someResult = 0;
    ...
    publish(someResult);
    ...
 }


@Override
protected void process(List<Integer> chunk) {
}
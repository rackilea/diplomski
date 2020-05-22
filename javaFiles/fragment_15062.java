timeTakenFunc(new Consumer<int[]>() {
    @Override public void accept(int[] arr) {
        foo(arr);
    }
});
timeTakenFunc(new Consumer<int[]>() {
    @Override public void accept(int[] arr) {
        bar(arr);
    }
});
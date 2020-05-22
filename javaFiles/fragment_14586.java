final Integer[] sum = new Integer[1];
sum[0] = 0;

myList.forEach(new Consumer() {
    public void accept(Integer element) {
        sum[0] = sum[0] + element;
    }
});
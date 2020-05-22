CustomArray<Integer> completeArray = new CustomArray<>(data);
ArrayList<CustomArray<Integer>> dividedArrays = completeArray.divideWork();

for(CustomArray<Integer> each : dividedArrays) {
    Foo foo = new Foo(each);
    new Thread(foo).start();

    // ... join through some method

    Integer value = foo.getValue();
}
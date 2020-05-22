Collection<Integer> collection = new LinkedList<>();
Integer[] numbers = new Integer[]{1, 2, 3, 4, 5};
Collections.addAll(collection, numbers);
// note the type of op
B<B<Integer>> op = new OperateAll<>(collection);
B<Integer> validateNumber = x -> x > 3;
op.operate(validateNumber);
B<String> validateString = x -> x.length() > 3;
op.operate(validateString); // error
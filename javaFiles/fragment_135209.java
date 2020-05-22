ArrayList<Integer> myNumbers = new ArrayList<>();
myNumbers.add(123);
myNumbers.add(456);
myNumbers.add(789);

for(int i = 0; i < myNumbers.size(); i++) {
    int value = myNumbers.get(i);
    if(value == 789) {
        System.out.println("Found 789 at index " + i);
        break;
    }
}
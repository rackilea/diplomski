int max = 100;

ArrayList<Integer> numbers = new ArrayList<>();
numbers.add(1);
numbers.add(54);
numbers.add(11);
numbers.add(6);
numbers.add(8);
numbers.add(32);

int randomQuestion = 0;
boolean exists = false;
do {
    randomQuestion = new Random().nextInt(max) + 1;
    exists = numbers.contains(randomQuestion);
} while(exists);
numbers.add(randomQuestion);

System.out.println(randomQuestion);
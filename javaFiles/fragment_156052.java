class Person {

    private final List<Integer> numbers;

    public Person( Integer... numbers){
        this.numbers = Arrays.asList(numbers);
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
}
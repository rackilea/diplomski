public void setEvenOdd(ArrayList<Integer> listOfNumbers) {
    ArrayList<Integer> even = new ArrayList<Integer>();
    for(Integer i : listOfNumbers) {
        if(i % 2 == 0) even.add(listOfNumbers.remove(i));
    }
    this.evenNumbers = even;
    this.oddNumbers = listOfNumbers; // since we removed all even numbers
}
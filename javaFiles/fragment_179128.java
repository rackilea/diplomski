class PrimeNumbersTask extends Task<List<Integer>> {
    PrimeNumbersTask(TextArea textArea, int numbersToFind) {
        // initialize
    }

    @Override
    protected List<Integer> call() throws Exception {
        while (!enough && !isCancelled()) {
            number = nextPrimeNumber();
            updateMessage(Integer.toString(number));
            updateProgress(numbers.size(), numbersToFind);
        }
        return numbers;
    }
}
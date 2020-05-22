class PrimeNumbersTask extends
        SwingWorker<List<Integer>, Integer> {

    PrimeNumbersTask(JTextArea textArea, int numbersToFind) {
        //initialize
    }

    @Override
    public List<Integer> doInBackground() {
        List<Integer> numbers = new ArrayList<Integer>(25);
        while (!enough && !isCancelled()) {
            number = nextPrimeNumber();
            numbers.add(number);
            publish(number);
            setProgress(100 * numbers.size() / numbersToFind);
        }

        return numbers;
    }

    @Override
    protected void process(List<Integer> chunks) {
        for (int number : chunks) {
            textArea.append(number + "\n");
        }
    }
}

JTextArea textArea = new JTextArea();
final JProgressBar progressBar = new JProgressBar(0, 100);
PrimeNumbersTask task = new PrimeNumbersTask(textArea, N);
task.addPropertyChangeListener(
 new PropertyChangeListener() {
     public  void propertyChange(PropertyChangeEvent evt) {
         if ("progress".equals(evt.getPropertyName())) {
             progressBar.setValue((Integer)evt.getNewValue());
         }
     }
 });

task.execute();
System.out.println(task.get()); //prints all prime numbers we have got
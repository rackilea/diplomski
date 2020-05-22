public class QsortViewer{
    private static final int MAX_ELEMENTS=150; 

     public static void main(String[] args){
        RandomGenerator RG = new RandomGenerator();
        QuickSort QS = new QuickSort();
        StopWatch SW = new StopWatch();

        double[] numbers = new double[MAX_ELEMENTS];

        System.out.println("Unordered set: ");
        for (int i = 0; i <= numbers.length-1; i++){
            numbers[i] = RG.randomLong(i*i*Math.sqrt(i)*Math.pow(i,i));
            System.out.print(numbers[i]+" ");
        }

        SW.start();
        System.out.println("Start Time: "+SW.getStartTime());

        numbers = QS,sort(numbers);

        SW.stop();
        System.out.println("Elapsed Time: "+SW.getElapsedTime());

        System.out.println("Sorted Array: ");
        for (int i = 0; i <= numbers.length-1; i++){
            System.out.print(numbers[i]+" ");
        }
    }
}
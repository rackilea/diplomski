public class ChangeArrayNSteps {

    public static void main(String[] args) {
        ChangeArrayNSteps cans = new ChangeArrayNSteps(8);

        cans.step(2, 1);

        System.out.println("Data: " + Arrays.toString(cans.data));
    }

    private final int[] data;

    public ChangeArrayNSteps(int size) {
        this.data = new int[size];
    }

    public void step(int interval, int value) {
        for (int index = 0; index < data.length; index += interval) {
            for (int stepIndex = index; stepIndex < index + interval; stepIndex++) {
                if (stepIndex > data.length - 1) {
                    return;
                }
                data[stepIndex] = value;
            }
            index += interval;
        }
    }

}
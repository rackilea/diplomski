public class InsertionSorter extends AbstracSorter {

    public InsertionSorter(int[] values) {
        super(values);
    }

    @Override
    public void sort() {
        setState(State.Sorting);
        new Thread(new SortRunnable()).start();
    }

    @Override
    protected void swap(int[] anArrayOfInt, int i, int j) {
        setActiveIndicies(i, j);
        int x = anArrayOfInt[i];
        anArrayOfInt[i] = anArrayOfInt[j];
        anArrayOfInt[j] = x;
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                @Override
                public void run() {
                    fireStateChanged();
                }
            });
        } catch (InterruptedException | InvocationTargetException exp) {
            exp.printStackTrace();
        }
    }

    public class SortRunnable implements Runnable {

        @Override
        public void run() {
            int[] values = getValues();
            for (int i = 0; i < values.length; ++i) {
                for (int j = i - 1; j >= 0 && values[j] > values[j + 1]; --j) {
                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException ex) {
                    }
                    swap(values, j, j + 1);
                }
            }
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    setState(State.Done);
                }
            });
        }
    }
}
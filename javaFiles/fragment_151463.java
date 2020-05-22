public class NumberOfCellsPrinter implements NumberOfCellsListener {
    public void numberOfCellsChanged(int patientId, int numOfCells) {
        System.out.println("The number of cells for parentId:" + parentId + " has changed to " + numOfCells + ".");
    }
}

...

public class PetriDish implements NumberOfCells {
    private ArrayList<NumberOfCellsListener> listeners = new ArrayList<>();
    private int numOfCells = 0;

    public void register(NumberOfCellsListener listener) {
        if (listener != null && !listeners.contains(listener)) {
            listeners.add(listener);
        }
    }

    public int numOfCells(int patientId) {
        for (NumberOfCellsListener listener : listeners) {
            listener.numberOfCellsChanged(parentId, numOfCells);
        }
        return numOfCells;
    }
}
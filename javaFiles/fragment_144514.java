public class NumberAction extends AbstractAction {

    private int number;

    public NumberAction(int number) {
        putValue(NAME, String.valueOf(number));
    }

    public int getNumber() {
        return number;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int value = getNumber();
        // Do something with the number...
    }

}
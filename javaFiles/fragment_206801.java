public interface GetButtonInterface {
    JButton getUserButton();
} 

public NewJFrame extends JFrame implements GetButtonInterface {
    private JButton newUserButton;

    @Override
    JButton getUserButton() {
        return newUserButton;
    }
}
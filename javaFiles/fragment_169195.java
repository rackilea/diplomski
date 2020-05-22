public final class SomeAction extends AbstractAction implements Presenter.Toolbar {

    private JButton button;

    @Override
    public void actionPerformed(ActionEvent e) {
        // change the button image
        ImageIcon icon = new ImageIcon("another_image.png");
        button.setIcon(icon);
    }

    @Override
    public Component getToolbarPresenter() {
        ImageIcon icon = new ImageIcon("image.png");

        // create the button to show
        button = new JButton(icon);
        button.addActionListener(this);

        return button;
    }
}
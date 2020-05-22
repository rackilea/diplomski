public class MyComboBox<E> extends JComboBox<E> {

    public MyComboBox(E[] list) {
        super(list);
        this.setEditable(true);
        this.setUI(new BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                return new JButton() {
                    @Override
                    public int getWidth() {
                        return 0;
                    }
                };
            }
        });
        this.remove(this.getComponent(0));
    }
}
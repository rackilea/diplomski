public interface UpDown{
    public JPanel getUp(JPanel parent);
    public JPanel getDown(JPanel parent);
}

public class CentralPage{
    static JPanel getInstance(UpDown components){
        JPanel container = new JPanel();
        container.setBackground(Color.white);
        container.setBorder(
                BorderFactory.createCompoundBorder(new LineBorder(Color.BLACK), new EmptyBorder(10, 10, 10, 10)));
        container.setMinimumSize(new Dimension(960, 400));
        container.setPreferredSize(new Dimension(960, 400));
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        JPanel up = components.getUp(container);
        container.add(up);
        JPanel down = components.getDown(container);
        container.add(down);
        return container;
    }
}
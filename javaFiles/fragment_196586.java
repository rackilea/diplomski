public abstract class CentralPage{

    private static CentralPage page;

    protected JPanel container;

    protected CentralPage(){
        container = new JPanel();
        container.setBackground(Color.white);
        container.setBorder(
               BorderFactory.createCompoundBorder(new LineBorder(Color.BLACK), new EmptyBorder(10, 10, 10, 10)));
        container.setMinimumSize(new Dimension(960, 400));
        container.setPreferredSize(new Dimension(960, 400));
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        JPanel up = getUp(container);
        container.add(up);
        JPanel down = getDown(container);
        container.add(down);
    }

    static JPanel getInstance(){
        if(page==null){
            page=new CentralPage();
        }
        return page.getContainer();
    }

    abstract JPanel getDown(JPanel container);

    abstract JPanel getUp(JPanel container);

    protected JPanel getContainer(){
         return this.container;
    }
}
public static JPanel content;
public static JPanel wrapper;

public APP()
{
    setLayout(new BorderLayout());
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    setJMenuBar(new MenuBar());

    content = new JPanel(new GridLayout(0, 8, 2, 2));

    wrapper = new JPanel(new BorderLayout()); 
    wrapper.add(Box.createGlue(), BorderLayout.CENTER);
    wrapper.add(content, BorderLayout.NORTH);
    add(new JScrollPane(wrapper, 22, 32), BorderLayout.CENTER);

    pack();
    setLocationRelativeTo(null);
    setResizable(false);
    setVisible(true);
}
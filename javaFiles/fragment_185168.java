public class Ex3 extends JFrame {

    private JList lista;
    private JList listaCopia;
    private static final String[] cores = {"Azul", "Verde", "Amarelo"};
    private static final Color[] cor = {Color.blue, Color.green, Color.yellow};
    private JButton copiar;
    DefaultListModel model;          <-- DefaultListModel

    public Ex3() {
        super("Utilizando JList");
        copiar = new JButton(" Copiar >>>> ");

        lista = new JList(cores);
        setLayout(new FlowLayout());
        lista.setVisibleRowCount(3); // definida linhas visíveis
        lista.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // método de seleção única de opções

        add(lista);
        add(copiar);

        listaCopia = new JList<String>();
        listaCopia.setVisibleRowCount(3);
        listaCopia.setFixedCellWidth(100);
        listaCopia.setFixedCellHeight(15);
        add(new JScrollPane(listaCopia));

        model = new DefaultListModel();         <-- initialize model
        listaCopia.setModel(model);             <-- set model

        copiar.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                       //listaCopia.setListData(lista.getSelectedValuesList().toArray());
                       model.addElement(lista.getSelectedValue());   <-- Add to model
                    }
                });
        lista.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                getContentPane().setBackground(cor[lista.getSelectedIndex()]);

            }
        });

    }
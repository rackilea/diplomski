public class MainView {
private JComponent view = null;

private ProgressView progressView = null;
private LoadDataView loadDataView = null;

public MainView(){
    progressView = new ProgressView();
    loadDataView = new LoadDataView();
}

public JComponent getView(){
    if (view == null) view = createView();
    return view;
}

private JComponent createView(){
    JPanel result = new JPanel( new BorderLayout() );

    result.add( progressView.getView(), BorderLayout.NORTH );
    result.add( loadDataView.getView(), BorderLayout.CENTER );

    return result;
}

public static void main(String[] args) throws IOException {
    MainView mainView = new MainView();

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    frame.getContentPane().add( mainView.getView() );

    frame.setSize(400, 200);
    frame.setVisible(true);
}
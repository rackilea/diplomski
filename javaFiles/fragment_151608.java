public class BookPage extends JFrame implements KeyListener {

    private static final long serialVersionUID = 1L;

    private AllBooks bookModel;

    private JTable bTabel;

    JTextField tf1;

    public BookPage() {
        bookModel = new AllBooks();
        bTabel = new JTable(bookModel);

        tf1 = new JTextField(20);
        tf1.addKeyListener(this);

        JPanel panel = new JPanel();
        JScrollPane scroolpane = new JScrollPane(bTabel);
        panel.add(tf1);
        panel.add(scroolpane);
        this.setContentPane(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(300, 60, 800, 600);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new BookPage().setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        String line = tf1.getText().trim();
        SearchBook(line);
    }

    public void SearchBook(String bid) {
        List<BookInformation> filtedRows = new ArrayList<BookInformation>();
        try {
            InputStream stream = getClass().getResourceAsStream("AllBookRecords.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
            String bs;
            while((bs = reader.readLine()) != null) {
                BookInformation information = new BookInformation();
                String[] Ust = bs.split("\\t");
                information.setBookID(Ust[0]);
                information.setBookName(Ust[1]);
                information.setBookDate(Ust[2]);
                information.setBorrowStatus(Ust[3]);
                if(information.getBookID().equals(bid) || information.getBookID().startsWith(bid)) {
                    filtedRows.add(information);
                }
            }
            if(!filtedRows.isEmpty()) {
                      //remove old rows
                for(int i = bookModel.getRowCount() - 1; i >= 0; i--) {
                    bookModel.RemoveMyRow(i);
                }
                     //add new rows
                for(BookInformation bookInformation : filtedRows) {
                    bookModel.AddRow(bookInformation);
                }
            }
            bookModel.fireTableDataChanged();

        } catch(IOException ex) {
            ex.getStackTrace();
            System.out.println(ex.getMessage());
        }
    }
}
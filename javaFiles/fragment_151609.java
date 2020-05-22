public class AllBooks extends AbstractTableModel {

    private static final long serialVersionUID = 1L;

    BookInformation Binfos1 = new BookInformation();

    String[] bCol = new String[] { "Id", "Name", "Date", "Borrow Status" };

    ArrayList<BookInformation> bData = new ArrayList<BookInformation>();

    public AllBooks() {
        try {
            InputStream stream = getClass().getResourceAsStream("AllBookRecords.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
            String line;

            while((line = reader.readLine()) != null) {
                bData.add(initializeBookInfos(line));
            }
            reader.close();
        } catch(IOException ioe) {

        }
    }

    public static BookInformation initializeBookInfos(String myLine) {
        BookInformation Binit = new BookInformation();
        String[] bookCellArray = myLine.split("\\t");
        Binit.setBookID(bookCellArray[0]);
        Binit.setBookName(bookCellArray[1]);
        Binit.setBookDate(bookCellArray[2]);
        Binit.setBorrowStatus(bookCellArray[3]);
        return Binit;
    }

    public void RemoveMyRow(int row) {
        if(RemoveBookFromFile(row)) {
            bData.remove(row);
            fireTableRowsDeleted(row, row);
        }
    }

    public boolean RemoveBookFromFile(int index) {

        File Mf = new File("AllBookRecords.txt");
        File Tf = new File("Boutput.txt");
        try {
            BufferedReader Ubr = new BufferedReader(new FileReader(Mf));
            PrintWriter Bpw = new PrintWriter(new FileWriter(Tf));
            String line;
            while((line = Ubr.readLine()) != null) {
                if(line.trim().length() == 0) {
                    continue;
                }
                if(!line.startsWith(String.valueOf(getValueAt(index, 0)))) {
                    Bpw.println(line);
                }
            }
            Bpw.close();
            Ubr.close();
            Mf.delete();
            Tf.renameTo(Mf);
            return true;
        } catch(FileNotFoundException e1) {
            return false;
        } catch(IOException ioe) {
            return false;
        }
    }

    public void AddRow(BookInformation bookinfo) {
        if(WriteBooktofile(bookinfo.toString())) {
            bData.add(bookinfo);
            fireTableRowsInserted(bData.size() - 1, bData.size() - 1);
        } else {
            JOptionPane.showMessageDialog(null, "Unable Add To File" + bookinfo.getBookName());
        }
    }

    public boolean WriteBooktofile(String bookc) {
        try {
            File f = new File("AllBookRecords.txt");

            FileWriter fw = new FileWriter(f.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(bookc);
            bw.close();
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    @Override
    public String getColumnName(int col) {
        return bCol[col];
    }

    @Override
    public int getRowCount() {
        if(bData != null) {
            return bData.size();
        } else {
            return 0;
        }
    }

    @Override
    public int getColumnCount() {
        return bCol.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        BookInformation binfo = bData.get(rowIndex);
        Object value;

        switch(columnIndex) {

            case 0:
                value = binfo.getBookID();
                break;
            case 1:
                value = binfo.getBookName();
                break;
            case 2:
                value = binfo.getBookDate();
                break;
            case 3:
                value = binfo.getBorrowStatus();
                break;
            default:
                value = "...";
        }
        return value;
    }

}
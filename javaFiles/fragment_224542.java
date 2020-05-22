public class MyJFileChooser extends JFileChooser {

    private static final int COLUMN_FILENAME = 0;
    private static final int COLUMN_FILESIZE = 1;
    private static final int COLUMN_FILETYPE = 2;
    private static final int COLUMN_FILEDATE = 3;
    private static final int COLUMN_FILEATTR = 4;
    private static final int COLUMN_COLCOUNT = 5;
    private static String[] COLUMNS = null;
    Vector detailsBtn = new Vector();
    UI ui;
    static JTable tbl;



    public void customizeFileChooser(Component[] comp) {

        int cnt = 1;

        for (int x = 0; x < comp.length; x++) {
            if (comp[x] instanceof JPanel) {
                customizeFileChooser(((JPanel) comp[x]).getComponents());


                Component[] c = ((JPanel) comp[x]).getComponents();
                for (int i = 0; i < c.length; i++) {

                    if (c[i] instanceof JTextField) {
                        ((JTextField) c[i]).setVisible(false);

                    }
                    if (c[i] instanceof JToggleButton) {

                        detailsBtn.add((JToggleButton) c[i]);
                        ((JToggleButton) c[i]).doClick();

                    }

                    if (c[i] instanceof JLabel) {

                        JLabel lbl = (JLabel) c[i];

                        if (x == 0 && i == 0) {
                            lbl.setVisible(false);
                        } else if (x == 2 && i == 0) {
                            lbl.setVisible(false);
                        } else if (x == 0 && i == 1) {

                            lbl.setVisible(false);
                        }

                    }

                    if (c[i] instanceof JComboBox) {
                        JComboBox b = (JComboBox) c[i];
                        if (x == 0 && i == 1) {
                            b.setVisible(false);
                        }
                        if (x == 2 && i == 1) {
                            b.setVisible(false);
                        }
                        if (x == 2 && i == 3) {
                            b.setVisible(false);
                        }


                    }

                }
            }
        }

    }

    public MyJFileChooser() {
        if (COLUMNS == null) {
            Locale l = getLocale();
            COLUMNS = new String[]{
                        UIManager.getString("FileChooser.fileNameHeaderText", l),
                        UIManager.getString("FileChooser.fileSizeHeaderText", l),
                        UIManager.getString("FileChooser.fileTypeHeaderText", l),
                        UIManager.getString("FileChooser.fileDateHeaderText", l),
                        UIManager.getString("FileChooser.fileAttrHeaderText", l)
                    };
        }

    }

    public void show() {
        MyJFileChooser fc = new MyJFileChooser();
        fc.showOpenDialog(MyJFileChooser.this);

    }


    /**************************************************************************
     * Always create the local UI
     * @param comp
     *************************************************************************/
    public final void setUI(ComponentUI comp) {
        super.setUI(ui = new UI(this));

    }


    /**************************************************************************
     * Internal implementation of Metal LookAndFeel to create the table sorting
     * ability.
     *************************************************************************/
    private final static class UI extends MetalFileChooserUI {

        private DirectoryModel model;

        /**************************************************************************
         * Must be overridden to extend
         * @param e
         *************************************************************************/
        public UI(JFileChooser e) {
            super(e);
        }

        /**************************************************************************
         * Overridden to create our own model
         *************************************************************************/
        protected final void createModel() {
            model = new DirectoryModel(getFileChooser());

        }

        /**************************************************************************
         * Overridden to get our own model
         * @return
         *************************************************************************/
        public final BasicDirectoryModel getModel() {
            return model;
        }

        /**************************************************************************
         * Calls the default method then adds a MouseListener to the JTable
         * @param chooser
         * @return
         *************************************************************************/
        protected final JPanel createDetailsView(JFileChooser chooser) {
            final JPanel panel = super.createDetailsView(chooser);

            //Since we can't access MetalFileChooserUI's private member detailsTable
            //directly, we have to find it in the JPanel
            tbl = findJTable(panel.getComponents());
            if (tbl != null) {

                //Fix the columns so they can't be rearranged, if we don't do this
                //we would need to keep track when each column is moved
                tbl.getTableHeader().setReorderingAllowed(false);

                //Add a mouselistener to listen for clicks on column headers
                tbl.getTableHeader().addMouseListener(new MouseAdapter() {

                    public void mouseClicked(MouseEvent e) {
                        //Only process single clicks
                        if (e.getClickCount() > 1) {
                            return;
                        }
                        e.consume();
                        final int col = tbl.getTableHeader().columnAtPoint(e.getPoint());
                        if (col == COLUMN_FILENAME || col == COLUMN_FILESIZE
                                || col == COLUMN_FILEDATE) {
                            model.sort(col, tbl);
                        }
                    }
                });
            }
            return panel;
        }

        /**************************************************************************
         * Finds the JTable in the panel so we can add MouseListener
         * @param comp
         * @return
         *************************************************************************/
        private final static JTable findJTable(Component[] comp) {
            for (int i = 0; i < comp.length; i++) {
                if (comp[i] instanceof JTable) {
                    return (JTable) comp[i];
                }
                if (comp[i] instanceof Container) {
                    JTable tbl = findJTable(((Container) comp[i]).getComponents());
                    if (tbl != null) {
                        return tbl;
                    }
                }
            }
            return null;
        }
    }

    /***************************************************************************
     * Implementation of BasicDirectoryModel that sorts the Files by column
     **************************************************************************/
    private final static class DirectoryModel extends BasicDirectoryModel {

        int col = 0;
        boolean ascending;

        /**************************************************************************
         * Must be overridden to extend BasicDirectoryModel
         * @param chooser
         *************************************************************************/
        DirectoryModel(JFileChooser chooser) {
            super(chooser);
        }

        /**************************************************************************
         * Supposedly this is not used anymore, hopefully not.  We implemented
         * some basic attempt at sorting just in case
         * @param a
         * @param b
         * @return
         *************************************************************************/
        protected final boolean lt(File a, File b) {
            System.out.println("LT called?");
            boolean less = false;
            switch (col) {
                case COLUMN_FILEDATE:
                    less = a.lastModified() > b.lastModified();
                    break;
                case COLUMN_FILESIZE:
                    less = a.length() > b.length();
                    break;
                default:
                    less = a.getName().compareToIgnoreCase(b.getName()) > 0;
                    break;
            }
            if (ascending) {
                return less = !less;
            }
            return less;
        }

        /**************************************************************************
         * Resorts the JFileChooser table based on new column
         * @param c
         *************************************************************************/
        protected final void sort(int c, JTable tbl) {
            //Set column and order
            col = c;
            ascending = !ascending;
            String indicator = " (^)";
            if (ascending) {
                indicator = " (v)";
            }

            final JTableHeader th = tbl.getTableHeader();
            final TableColumnModel tcm = th.getColumnModel();

            for (int i = 0; i < MyJFileChooser.COLUMN_COLCOUNT - 1; i++) {
                final TableColumn tc = tcm.getColumn(i); // the column to change
                tc.setHeaderValue(COLUMNS[i]);
            }

            final TableColumn tc = tcm.getColumn(col); // the column to change
            tc.setHeaderValue(COLUMNS[col] + indicator);

            th.repaint();

            //Requery the file listing
            validateFileCache();
        }

        /**************************************************************************
         * Sorts the data based on current column setting
         * @param data
         *************************************************************************/
        protected final void sort(Vector data) {
            switch (col) {
                case COLUMN_FILEDATE:
                    Collections.sort(data, new Comparator() {

                        public int compare(Object o1, Object o2) {
                            int ret = 1;
                            final File a = (File) o1;
                            final File b = (File) o2;
                            if (a.lastModified() > b.lastModified()) {
                                ret = -1;
                            } else if (a.lastModified() == b.lastModified()) {
                                ret = 0;
                            }

                            if (ascending) {
                                ret *= -1;
                            }
                            return ret;
                        }
                    });
                    break;
                case COLUMN_FILESIZE:
                    Collections.sort(data, new Comparator() {

                        public int compare(Object o1, Object o2) {
                            int ret = 1;
                            final File a = (File) o1;
                            final File b = (File) o2;
                            if (a.length() > b.length()) {
                                ret = -1;
                            } else if (a.length() == b.length()) {
                                ret = 0;
                            }

                            if (ascending) {
                                ret *= -1;
                            }
                            return ret;
                        }
                    });
                    break;
                case COLUMN_FILENAME:
                    Collections.sort(data, new Comparator() {

                        public int compare(Object o1, Object o2) {
                            final File a = (File) o1;
                            final File b = (File) o2;
                            if (ascending) {
                                return a.getName().compareToIgnoreCase(b.getName());
                            } else {
                                return -1 * a.getName().compareToIgnoreCase(b.getName());
                            }
                        }
                    });
                    break;
            }
        }
    }
    }
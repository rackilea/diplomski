//object to contain the filter
public class FilterSelection {
    private JLabel importOption;
    private JComboBox importSelection;

    public FilterSelection (JLabel importOption, JComboBox importSelection){
        this.importOption = importOption;
        this.importSelection = importSelection;
    }

    public JComboBox getImportSelection() {
        return this.importSelection;
    }
}

//builds a filter to determine what each column in Excel the cells represent
public class ImportFilter extends JDialog {
    private TreeMap<Integer, String> headerList = new TreeMap<Integer, String>();
    private ArrayList<FilterSelection> filterList = new ArrayList<FilterSelection>();

    public ImportFilter(...) {
        getContentPane().setLayout(new BorderLayout());
        buildFilterSelection(...));
        addFilter(headerList);
    }

    public void buildFilterSelection(...) {
        //builds a TreeMap from data in Excel cells
        for(Iterator<Cell> cit = row.cellIterator(); cit.hasNext();) {
            headerList.put(cell.getColumnIndex(), cell.getStringCellValue().trim());
        }
    }

    public void addFilter(TreeMap<Integer, String> headerList) {
        JPanel importFilter = new JPanel();
        JScrollPane scrollPane = new JScrollPane(importFilter);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        //iterates through the TreeMap to create a JComboBoxe and JLabel for each Excel cell with data in the header row
        Set set = headerList.entrySet();
        Iterator headerIterator = set.iterator();
        while (headerIterator.hasNext()) {
            Map.Entry headerMap = (Map.Entry)headerIterator.next();
            String header = (String) headerMap.getValue();

            final JComboBox comboBox;
            JLabel label = new JLabel(header);
            comboBox = new JComboBox(new String[] {"", "Location", "Latitude", "Longitude", "Label", "Description"});

            //uses JLabel text to determine what object to select in the JComboBox
            switch (label.getText().toUpperCase()) {
            case "LOCATION":
                if (locationFilter == false) {
                    comboBox.setSelectedIndex(1);
                    locationFilter = true;
                }
                break;
            case "NAME":
                if (labelFilter == false) {
                    comboBox.setSelectedIndex(4);
                    labelFilter = true;
                    }
                break;
            }

            //adds JComboBox and JLable to ArrayList
            FilterSelection filter = new FilterSelection(label, comboBox);
            filterList.add(filter);
            comboBox.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent ie) {
                    //do something here when the JComboBox is changed
                }
            });

            //adds JComboBox and JLabel to the JPanel
            importFilter.add(label);
            importFilter.add(comboBox);
        }
    }
}

//runs through an entire Excel sheet and references the filter to determine how the cells are formatted based on their column
public class PointsBuilder {
    public void PointsBuilder (ArrayList<FilterList> filterList) {
        for(Iterator<Cell> cit = row.cellIterator(); cit.hasNext();) {
            Cell cell = cit.next();
            cell.setCellType(Cell.CELL_TYPE_STRING);
            try {
                //checks the filter for the corresponding column of the cell being read
                switch (filterList.get(cell.getColumnIndex()).getImportSelection().getSelectedIndex()) {
                    case 0:
                        //the column of this cell had no values in the filter
                        break;
                    case 1:
                        //the column of this cell contains a location
                        break;
                    case 4:
                        //the column of this cell contains a label
                        break;
                    case 5:
                        //the column of this cell contains a description
                        break;
                }
            } catch (IndexOutOfBoundsException e) {
                //this block catches any data that is in columns beyond where the filter ended based on the header info (ex: last header column = 5; current cell column = 7)
            }
        }
    }
}
public class TableExample {

//Asuming you have a treemap like this
static Map<Date, String> sampleMap = new TreeMap<Date, String>();

//Initialize the sample treemap with some values (this static block will execute the first time we run this app)
static {
    sampleMap.put(createBirthdayFromString("14/02/1990"), "Marcelo's Birthday");
    sampleMap.put(createBirthdayFromString("29/06/1989"), "Oscar's Birthday");
    sampleMap.put(createBirthdayFromString("21/04/1985"), "Carlos' Birthday");
}

//This will create a date object based on a given String
public static Date createBirthdayFromString(String dateAsString) {
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    Date convertedDate = null;
    try {
        convertedDate = formatter.parse(dateAsString);
    } catch (ParseException e) {
        // Print stacktrace and default to current Date
        e.printStackTrace();
        convertedDate = new Date();
    }
    return convertedDate;
}

public void init() {
    //Create the JFrame to display the table
    JFrame mainFrame = new JFrame();
    mainFrame.setTitle("My Table Example");
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainFrame.setSize(520, 520);

    //Then a panel to keep our Main frame available to display other contents
    JPanel myPanel = new JPanel();
    myPanel.setBounds(mainFrame.getBounds());
    myPanel.setBackground(Color.DARK_GRAY);
    myPanel.setVisible(true);

    //Add the panel to the frame
    mainFrame.add(myPanel);

    //You will need to specify the columns you want to display in your table, for this case:
    String[] columns = new String[] {"Birthday", "Name"};

    //Then you can create a table model with zero rows at the beginning
    //The table model will define how the data in your table would be displayed
    //As well as provide some useful methods if you want to add certain events or edition capabilities :)
    DefaultTableModel defaultModel = new DefaultTableModel(columns, 0);

    //Then you create your table based on your model
    JTable myTable = new JTable(defaultModel);

    //Then you will like to fill each table row with the data of your treemap

    //We iterate over your map to obtain the records
    for (Map.Entry<Date, String> entry : sampleMap.entrySet()) {
        defaultModel.addRow(new Object[] {entry.getKey(), entry.getValue()});
    }

    //Now add the table to your frame
    myPanel.add(new JScrollPane(myTable));

    //Set the frame visible
    mainFrame.setVisible(true);
}

/**
 * Main method that will execute this example
 * @param args
 */
public static void main(String[] args) {
    new TableExample().init();
}   
}
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.event.TableModelEvent;
import javax.swing.table.*;
// ResultSet rows and columns are counted from 1 and JTable
// rows and columns are counted from 0. When processing
// ResultSet rows or columns for use in a JTable, it is
// necessary to add 1 to the row or column number to manipulate
// the appropriate ResultSet column (i.e., JTable column 0 is
// ResultSet column 1 and JTable row 0 is ResultSet row 1).

public class ResultSetTableModel extends AbstractTableModel {

    private static final long serialVersionUID = 1L;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private ResultSetMetaData metaData;
    private int numberOfRows;
    // initialize resultSet and obtain its meta data object determine number of rows

    public ResultSetTableModel(String driver, String url,
            String query) throws SQLException, ClassNotFoundException {
        Class.forName(driver);// load database driver class        
        connection = DriverManager.getConnection(url);// connect to database
        // create Statement to query database
        statement = connection.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        setQuery(query);// set query and execute it
    }

    @Override// get class that represents column type
    public Class<?> getColumnClass(int column) {// determine Java class of column        
        try {
            String className = metaData.getColumnClassName(column + 1);
            return Class.forName(className); // return Class object that represents className
        } // catch SQLExceptions and ClassNotFoundExceptions
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return Object.class;// if problems occur above, assume type Object
    }

    @Override// get number of columns in ResultSet
    public int getColumnCount() {
        try { // determine number of columns
            return metaData.getColumnCount();
        } // catch SQLExceptions and print error message
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return 0; // if problems occur above, return 0 for number of columns
    }

    @Override // get name of a particular column in ResultSet
    public String getColumnName(int column) {
        // determine column name
        try {
            return metaData.getColumnName(column + 1);
        } // catch SQLExceptions and print error message
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return "";// if problems, return empty string for column name
    }

    @Override// return number of rows in ResultSet
    public int getRowCount() {
        return numberOfRows;
    }

    @Override // obtain value in particular row and column
    public Object getValueAt(int row, int column) {
        try {  // obtain a value at specified ResultSet row and column
            resultSet.absolute(row + 1);
            return resultSet.getObject(column + 1);
        } // catch SQLExceptions and print error message
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        fireTableCellUpdated(row, column);
        return "";// if problems, return empty string object
    }

    @Override // close Statement and Connection
    protected void finalize() {
        try { // close Statement and Connection
            statement.close();
            connection.close();
        } // catch SQLExceptions and print error message
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    // *******set new database query string*********
    public void setQuery(String query) throws SQLException {
        // specify query and execute it
        resultSet = statement.executeQuery(query);
        // obtain meta data for ResultSet
        metaData = resultSet.getMetaData();
        // determine number of rows in ResultSet
        resultSet.last();                   // move to last row
        numberOfRows = resultSet.getRow();  // get row number
        // notify JTable that model has changed
        fireTableStructureChanged();
        fireTableChanged(null);
    }

    public void tableChanged(TableModelEvent e) {
        fireTableChanged(e);
    }
}
package forum10794522;

import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "table")
public class Table {

    static Table EXAMPLE_TABLE;
    static {
        EXAMPLE_TABLE = new Table();
        EXAMPLE_TABLE.tableName = "GGS_MARKER";
        EXAMPLE_TABLE.rowCount = 19190;
        List<Column> columns = new ArrayList<Column>(2);
        columns.add(new Column());
        columns.add(new Column());
        EXAMPLE_TABLE.columnList = columns;
    }

    private String tableName;
    private int rowCount;
    private List<Column> columnList;

    @XmlElement(name = "name")
    public String getTableName() {
        return tableName;
    }

    @XmlElement(name = "rowCount")
    public int getRowCount() {
        return rowCount;
    }

    @XmlElement(name = "column")
    public List<Column> getColumnList() {
        return columnList;
    }

}
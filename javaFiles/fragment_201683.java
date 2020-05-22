import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;

/**
 * id  var_a var_b
 * --  ----- -----
 * 01  1     2
 * 02  3     0
 *
 * becomes
 * 
 * id  var_name var_value
 * --  -------- ---------
 * 01  var_a    1  
 * 01  var_b    2
 * 02  var_a    3
 * 02  var_b    0 
 *
 */
public class OneToManyMapFunction implements FlatMapFunction<Row, Row> {

    //indexes of fields that won't change in the new rows (id)
    private int[] fixedFields = {0};
    //indexes of fields that will create new rows (var_a, var_b)
    private int[] dynamicFields = {1, 2};
    //names of the dynamic fields
    private String[] dynamicFieldsName = {"var_a", "var_b"};

    public OneToManyMapFunction() {}

    @Override
    public Iterable<Row> call(Row row) throws Exception {

        List<Row> rows = new ArrayList<Row>();
        Object[] fixedValues = ArrayUtils.EMPTY_OBJECT_ARRAY;

        //add values that won't change in the new rows
        for (int i = 0; i < fixedFields.length; i++) {
            fixedValues = ArrayUtils.add(fixedValues, row.get(fixedFields[i]));
        }

        //create new rows
        for (int i = 0; i < dynamicFields.length; i++) {
            //copy fixed values (id)
            Object[] values = ArrayUtils.clone(fixedValues);

            //add dynamic value name (var_a or var_b)
            values = ArrayUtils.add(values, dynamicFieldsName[i]);
            //add dynamic value
            values = ArrayUtils.add(values, row.get(dynamicFields[i]));

            //create new row for dynamic val
            Row newRow = RowFactory.create(values);
            rows.add(newRow);
        }

        return rows;
    }

}
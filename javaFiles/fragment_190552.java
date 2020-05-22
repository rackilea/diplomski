/* The type has to be SQL type so that it is also visible for Java. */
create or replace type widgets_t is table of varchar2(32767);
/

create or replace and compile java source named "so19ja" as
import java.lang.*;
public class so19ja {
    public static String[] get_widgets_as_array() {
        String[] widgets = new String[]{"foo", "bar", "zoo"};
        return widgets;
    }

    public static java.sql.Array array_wrapper(
        String typeName,
        Object elements
    ) throws java.sql.SQLException {
        oracle.jdbc.OracleDriver ora = new oracle.jdbc.OracleDriver();
        java.sql.Connection conn = ora.defaultConnection();
        oracle.jdbc.OracleConnection oraConn =
            (oracle.jdbc.OracleConnection)conn;
        /* Yeah - typeName have to be UPPERCASE, really. */
        java.sql.Array arr = 
            oraConn.createARRAY(typeName.toUpperCase(), elements);
        return arr;
    }

    public static java.sql.Array get_widgets_as_array_wrapped()
    throws java.sql.SQLException {
        return array_wrapper("widgets_t", get_widgets_as_array());
    }
};
/
show errors java source "so19ja"

create or replace function get_widgets_as_array return widgets_t as
language java name 'so19ja.get_widgets_as_array_wrapped() return java.sql.Array';
/
show errors

declare
  widgets constant widgets_t := get_widgets_as_array;
begin
  for i in widgets.first .. widgets.last loop
    dbms_output.put_line('widgets(' || i || ') = ' || widgets(i));
  end loop;
end;
/
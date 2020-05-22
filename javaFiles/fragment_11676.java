/**
 * The Unicode Char for "object replacement character"
 */
private final static char REPLACEMENT_CHAR = '\uFFFC';

/**
 * Split an SQL INSERT or UPDATE Statement to return the map of (column_name, values)
 * @param sql  the statement
 * @return the map with the column names as key and the sql values as values
 */
public static final SortedMap<String, String> getValuesFromSqlStatement (String sql)
{
    // check the argument
    if (sql==null || sql.trim().length() == 0)
        throw new IllegalArgumentException("The sql string cannot be empty");
    sql = sql.trim();

    final String ucSql = sql.toUpperCase();
    if (!ucSql.startsWith("INSERT") && !ucSql.startsWith("UPDATE"))
        throw new IllegalArgumentException("The sql string is neither an insert nor an update");

    // extract the column names
    Pattern pattern;
    pattern = Pattern.compile("[^(]*\\(([^)]*)\\).*");
    final Matcher m = pattern.matcher(sql);
    m.matches();
    final String columList = m.group(1);
    final String[] columns = columList.trim().split("\\s*,\\s*");

    // replace the , chars inside of strings by the REPLACEMENT_CHAR
    final char[] rest = sql.substring(sql.indexOf("VALUES")).toCharArray();
    boolean inString = false;
    int start = -1;
    int end   = -1;
    for (int i = 0; i<rest.length; i++)
    {
        final char c = rest[i];
        if ( inString && c == ',')
        {
            rest[i] = REPLACEMENT_CHAR;
        }
        else if ( c=='\'')
        {
            inString = !inString;
        }
        else if (!inString && c == '(')
        {
            if (start != -1)
                throw new AssertionError("Start brace found twice!");

            start = i+1;
        }
        else if (!inString && c == ')')
        {
            end = i-1;
            break;
        }
    }

    if (start == -1 || end == -1)
        throw new AssertionError("Start or end of the values part not found!");


    // split the result for having the values
    final String[] values = new String(rest, start, end-start+1).split("\\s*,\\s*");
    if (values.length != columns.length)
        throw new AssertionError("The number of values differs of the number of columns");

    // reset the , char in the values containing REPLACEMENT_CHAR and collect the results
    final TreeMap<String, String> map = new TreeMap<String, String>();
    for (int i=0; i<values.length; i++)
    {
        if (values[i].indexOf(REPLACEMENT_CHAR) != -1)
        {
            values[i] = values[i].replace(REPLACEMENT_CHAR, ',');
        }

        map.put(columns[i], values[i]);
    }

    return map;
}
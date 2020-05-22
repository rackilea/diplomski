//Declare a variable of returned type value
String brandname = "";
double equity = 0.0;

//Call Function value(DbObject,Nested_Path,variable)
while (tweet.hasNext()) {

                    DBObject t = tweet.next();
                    brandname = value(t, "brand", brandname);
                    equity = value(t, "bei.equity", equity);

}
//Generic Function
public static <T> T value(DBObject t, String header, T element) {

        if (header.contains(".")) {
            String children[] = header.split("\\.");
            int i = 1;
            DBObject temp = t;
            for (String child : children) {
                if (i == children.length) {
                    element = (T) temp.get(child);
                    return element;
                } else {
                    temp = (DBObject) temp.get(child);
                }
                i++;

            }
        } else {
            element = (T) t.get(header).toString();
            return element;
        }
        return null;

    }
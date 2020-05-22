class Demo {

public Vector getVector(ResultSet theInfo) {
    if(theInfo==null){
        throw new IllegalArgumentException("ResultSet is null");
    }
    Vector aVector = new Vector();
    try {
        while (theInfo.next()) {
            aVector.addElement(new String(theInfo.getString("aColumn"))); 
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
    return aVector;
}
public class PointType implements UserType{
private static final Type[] PROPERTY_TYPES = new Type[] { 
    StringType.INSTANCE };
public String[] getPropertyNames() {
     return new String[] {"point"};   }

public Type[] getPropertyTypes() {
    return PROPERTY_TYPES;
}


public Class returnedClass() {
   return Point.class;
}

public boolean equals(Object o, Object o1) throws HibernateException {
    if((o instanceof Point && o1 instanceof Point) == false)
        return false;
    Point p1 = (Point) o;
    Point p2 = (Point) o1;
    boolean equal = ((p1.getX() == p2.getX()) && (p1.getY() == p2.getY()));
    return equal;


}   

public Object nullSafeGet(ResultSet rs, String[] strings, SessionImplementor si, Object o) throws HibernateException, SQLException {
// the method which gets the data from the column and converts it to a Point using       BinaryParser
   BinaryParser bp = new BinaryParser();       
   try{          
      String binaryString = rs.getString(strings[0]);
       return bp.parse(binaryString);
   }
   catch(Exception ex){ return null;}

}

public void nullSafeSet(PreparedStatement ps, Object o, int i, SessionImplementor si) throws HibernateException, SQLException {
    Point p = (Point) o ;
    if(p!=null){
       BinaryWriter bw = new BinaryWriter();
       ps.setObject(i,bw.writeBinary(p));      
    }

public Object deepCopy(Object o) throws HibernateException {
    Point p = (Point) o;        
    Point newPoint = null;
    if(p!=null){
        newPoint = new Point(p.x, p.y);
        newPoint.setSrid(p.getSrid());
    }
    return newPoint;

}

public boolean isMutable() {
    return true;
}


public int[] sqlTypes() {
    return new int[]{Types.BINARY};
}
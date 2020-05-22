Object[] b=new Object[5];
while (rs.next()) {
    Vector r = new Vector();   // sql data to vector
    r.add(rs.getInt("Pre1"));
    r.add(rs.getInt("Pre2"));
    r.add(rs.getInt("Pre3"));
    r.add(rs.getInt("Pre4"));
    r.add(rs.getInt("Pre5"));
    System.out.println(r);
    Object[] array1 = new Object[5];
    r.copyInto(b);
}
CountMatching(array,b);
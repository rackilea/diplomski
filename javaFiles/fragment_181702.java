if (!resultSet.next() ) {
    System.out.println("resultset does not data");
} else {

    do {
        System.out.println(rs.getString(1)+"  "+
                           rs.getString(2)+"  "+
                          rs.getString(3)+"  "+
                          rs.getString(4));


    } while (resultSet.next());
}
while(rs.next()) {
    for (int i = 1; i <= columnCount; i++) {
        System.out.print(rs.getObject(i) + ", ");
    }
    System.out.println();
}
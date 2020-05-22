if(rs != null && rs.next()) {
    out.println("result set has got something");
    do {
        // do what you have to do
    } while (rs.next());
} else {
    out.println("result set is empty");
}
while(result.next()) {
    Person p = new Person();
    p.setId( result.getInt("id") );
    p.setfName( result.getString("Firstname ") );
    // ...
}
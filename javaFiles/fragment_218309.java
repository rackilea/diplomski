try{
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/uni_db", "postgres", "postgres");
        System.out.println("Success.");
} catch(SQLException e){
        System.out.println("Couldn't connect: exit.");
        System.exit(1);}
    return conn;
}
public static void ProducerDB(String[] args){
    ConnectionFactory factory = null;
    javax.jms.Connection connection = null;
    Session session = null;
    Destination destination = null;
    MessageProducer producer = null;
    Connection c = null;
    Statement stmt = null;
    try {
    Class.forName("org.postgresql.Driver");
    c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"TestDB, "admin", "admin");
    c.setAutoCommit(false);
    System.out.println("----------------------------");
    factory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
    connection = factory.createConnection();
    connection.start();
    session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
    destination = session.createQueue("TestQueue");
    producer = session.createProducer(destination);

    stmt = c.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT * FROM MESSAGES;");
    while (rs.next()) {
        String  message = rs.getString("MESSAGE");
        System.out.println("Message = " + message);
            try {
                TextMessage mssg = session.createTextMessage(message);
                System.out.println("Sent: " + mssg.getText());
                producer.send(mssg);
            }
            catch (JMSException e) {
                e.printStackTrace();
            }
    }
    }catch (Exception e) {
        System.err.println(e.getClass().getName()+": "+ e.getMessage());
    }finally{
        if (c != null) {
            c.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
    System.out.println("----------------------------");
    System.out.println("Message sent successfully");
}
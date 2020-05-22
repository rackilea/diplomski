@Autowired
            ConnectionFactory factory;

            ....
            factory.setHost("localhost");
            factory.setPort(qpid_server_port);
            try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
                String queue = "queue-x";
                channel.queueDeclare(queue, true, false, false, null);
                //channel.queueBind(queue, "exchange-x" , "routing-key-x");

            } catch (Exception e) {
                e.printStackTrace();
            }
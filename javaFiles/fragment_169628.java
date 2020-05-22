@Transactional
            @RabbitListener(queues = "someEvent")
            @Override
            public void onMessage(Message message, Channel channel) throws Exception 
            {
                System.out.println(new String(message.getBody()));
                System.out.println(channel);
                super.onMessage(message, channel);
            }
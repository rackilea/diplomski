template.execute(new SessionCallback<QueueBrowser>() {
            public QueueBrowser doInJms(Session session) throws JMSException {
                QueueBrowser browser =  session.createBrowser(queue);
                Enumeration messages = browser.getEnumeration();
                int num = 0;
                logger.info("" + messages.hasMoreElements());
                while(messages.hasMoreElements()) {
                    messages.nextElement();
                    num +=1;
                }
                logger.info("Num = " + num);
                return null;
            }
        }, true);
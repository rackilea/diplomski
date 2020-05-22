ConnectionFactory factory = new ActiveMQConnectionFactory(url);
RedeliveryPolicy policy = new RedeliveryPolicy();
policy.setBackOffMultiplier((short) 2);
policy.setRedeliveryDelay(30000);
policy.setInitialRedeliveryDelay(60000);
policy.setUseExponentialBackOff(true);
((ActiveMQConnectionFactory)factory).setRedeliveryPolicy(policy);

final Session session = connection.createSession(false,
                Session.CLIENT_ACKNOWLEDGE);
...
...
...
..


//inside onMessage()
try {
    if (DB is available){
        //process message
        //save required details to DB
        msg.acknowledge();
    }
    else{
        session.recover();
    }
    } catch (Exception e) {}
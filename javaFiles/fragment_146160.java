from("activemq:topic:topicName")
       .multicast()
           .to("seda:server1", "seda:server2", "seda:server3");

from("seda:server1").to("my_component:server1").to("seda:aggregator");
from("seda:server2").to("my_component:server2").to("seda:aggregator");
from("seda:server3").to("my_component:server3").to("seda:aggregator");

 from("seda:aggregator")
       .aggregate(new SingleGroupExpression(), new ServerResponseAggregator())
           .completionSize(3)
           .completionTimeout(10000)
 .to("my_component:client")
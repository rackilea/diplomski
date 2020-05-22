JaxbDataFormat dataFormat = new JaxbDataFormat();
dataFormat.setContextPath("com.somepath.xml");

from("jms:topic:myTopic?transacted=true&connectionFactory=myJmsConnectionFactory")
 .transacted()
 .unmarshal(dataFormat)
 .routeId("myRouteId")
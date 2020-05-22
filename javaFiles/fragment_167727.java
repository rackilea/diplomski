javax.naming.ServiceUnavailableException: Unable to connect to the target
queue manager localhost:1414/SYSTEM.DEF.SVRCONN [Root exception is
com.ibm.mq.MQException: MQJE001: Completion Code '2', Reason '2539'.


Caused by: com.ibm.mq.jmqi.JmqiException: CC=2;RC=2539;
AMQ9204: Connection to host 'localhost(1414)' rejected.
[1=com.ibm.mq.jmqi.JmqiException[CC=2;RC=2539;
AMQ9503: Channel negotiation failed. [3=SYSTEM.DEF.SVRCONN]],
3=localhost(1414),5=RemoteConnection.initSess]

Caused by: com.ibm.mq.jmqi.JmqiException: CC=2;RC=2539;
AMQ9503: Channel negotiation failed. [3=SYSTEM.DEF.SVRCONN]
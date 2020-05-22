int openOptions = CMQC.MQSO_CREATE | CMQC.MQSO_FAIL_IF_QUIESCING | CMQC.MQSO_MANAGED | CMQC.MQSO_NON_DURABLE;

MQTopic subscriber = qMgr.accessTopic( topicString,
                                       null,
                                       CMQC.MQTOPIC_OPEN_AS_SUBSCRIPTION,
                                       openOptions);
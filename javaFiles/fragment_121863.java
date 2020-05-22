ManagerConnectionFactory factory = new 
 ManagerConnectionFactory("serverIp", "username",
                    "passwd");
 ManagerConnection managerConnection=factory.createManagerConnection()
    OriginateAction originateAction=new OriginateAction();

     final String randomUUID=java.util.UUID.randomUUID().toString();

            System.out.println("ID random:_"+randomUUID);

            originateAction.setChannel([connectionType]+"/"+[callerExtension]);<-- SIP or PJSIP / 201(the phone that will ring first)
            originateAction.setContext("from-internal"); <-- Default FreePBX context
            originateAction.setCallerId([callerId]); // what will be showed on the phone screen (in most cases your phone)
            originateAction.setExten([targetExten]); //where to call.. the target extension... internal extension or the outgoing number.. the 0[nomberToCall] 
            originateAction.setPriority([priority]);// priority of the call
            originateAction.setTimeout(timeoutCall); // the time that a pickup event will be waited for
            originateAction.setVariable("UUID", randomUUID); // asigning a unique ID in order to be able to hangup the call.
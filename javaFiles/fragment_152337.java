request = new PCFMessage(CMQCFC.MQCMD_INQUIRE_CHANNEL_STATUS);
request.addParameter(CMQCFC.MQCACH_CHANNEL_NAME, "TEST.CHL");
request.addParameter(CMQCFC.MQIACH_CHANNEL_INSTANCE_TYPE, CMQC.MQOT_CURRENT_CHANNEL);
request.addParameter(CMQCFC.MQIACH_CHANNEL_INSTANCE_ATTRS,
                     new int []
                     {
                        CMQCFC.MQCACH_CHANNEL_NAME,
                        CMQCFC.MQCACH_CONNECTION_NAME,
                        CMQCFC.MQIACH_CHANNEL_STATUS,
                        CMQCFC.MQIACH_CHANNEL_SUBSTATE,
                        CMQCFC.MQIACH_MSGS,
                        CMQCFC.MQCACH_LAST_MSG_DATE,
                        CMQCFC.MQCACH_LAST_MSG_TIME,
                        CMQCFC.MQCACH_CHANNEL_START_DATE,
                        CMQCFC.MQCACH_CHANNEL_START_TIME,
                        CMQCFC.MQIACH_BYTES_SENT,
                        CMQCFC.MQIACH_BYTES_RECEIVED,
                        CMQCFC.MQIACH_BUFFERS_SENT,
                        CMQCFC.MQIACH_BUFFERS_RECEIVED,
                        CMQCFC.MQIACH_MCA_STATUS,
                        CMQCFC.MQCACH_MCA_JOB_NAME,
                        CMQCFC.MQCACH_MCA_USER_ID
                     } );

responses = agent.send(request);
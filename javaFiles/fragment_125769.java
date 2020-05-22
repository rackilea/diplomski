PCFParameter[] parameters = { new MQCFST(CMQC.MQCA_Q_NAME, "*"), new MQCFIN (CMQC.MQIA_Q_TYPE, CMQC.MQQT_LOCAL) };
 agent.send(..);
 // etc.. Get local queues
parameters = { new MQCFST(CMQC.MQCA_Q_NAME, "*"), new MQCFIN (CMQC.MQIA_Q_TYPE, CMQC.MQQT_ALIAS) };
 agent.send(..);

 // etc.. get alias queues

 // TODO: now build a list of all queues, local and alias.
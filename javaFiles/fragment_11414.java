// Create the PCF message type for the inquire.
PCFMessage pcfCmd = new PCFMessage(MQConstants.MQCMD_INQUIRE_Q_STATUS);
// Add queue name
pcfCmd.addParameter(MQConstants.MQCA_Q_NAME, "MYQ");
// We want Q HANDLE attributes
pcfCmd.addParameter(MQConstants.MQIACF_Q_STATUS_TYPE, MQConstants.MQIACF_Q_HANDLE);
// We want to retrieve only the connection name
pcfCmd.addParameter(MQConstants.MQIACF_Q_STATUS_ATTRS, MQConstants.MQCACH_CONNECTION_NAME);
// Execute the command. The returned object is an array of PCF messages.
PCFMessage[] pcfResponse = pcfCM.agent.send(pcfCmd);

try{
    for(int i = 0; i < pcfResponse.length;i++){
        String name = (String) pcfResponse[i].getParameterValue(MQConstants.MQCACH_CONNECTION_NAME);
        System.out.println("Connection Name: " + name);         
        }
    }catch(Exception ex) {
    System.out.print(ex);
}
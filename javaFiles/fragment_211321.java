// type is-a String
switch(type) {
    case "AD": return new ADCommunicator();
    case "DB2": return new DB2Communicator();
    case "MYSQL": return new MYSQLCommunicator();
    default: return null;
}
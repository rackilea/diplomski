Ack_Nak ack_nak = anotherClass.getDataByte();
switch (ack_nak) {
        case ACK:
            //do something here
            break;
        case NAK:
        case NAK_CRC:
        case NAK_DATA:
        case NAK_FILE:
        case NAK_SIZE:
            //act on the failure here
            break;
        default:  //just incase
            break;
}
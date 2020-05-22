byte ack_nak = anotherClass.getDataByte();
switch (ack_nak) {
    case 0x01:
        //do something here
        break;
    case 0x00:
    case 0x51:
    case 0xCC:
    case 0xD8:
    case 0xF1:
    Toast.makeText(MainActivity.this,Ack_Naks.name() , Toast.LENGTH_SHORT).show();  //show failure
    //act on the failure here
        break;
    default:  //just incase
        break;
}
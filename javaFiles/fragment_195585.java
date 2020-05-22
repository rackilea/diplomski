byte buzzerOn = (byte)0xFF;
byte buzzerOff = (byte)0x00;
byte clazz = (byte)0xFF;
byte ins = (byte)0x00;
byte p1 = (byte)0x52;
byte p2 = buzzerOff;
byte le = (byte)0x00;

byte[] apdu = new byte[]{clazz,ins,p1,p2,le};
ResponseAPDU answer = cardChannel.transmit( new CommandAPDU(apdu));

byte successSW1 = (byte)0x90;
byte successSW2 = (byte)0x00;
if(answer.getSW1() == successSW1 && answer.getSW2() == successSW2){
    //done
}else{
    //failed
}
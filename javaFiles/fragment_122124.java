void selectApplication(CardChannel channel) throws CardException {
  byte[] masterCardRid = new byte[]{0xA0, 0x00, 0x00, 0x00, 0x04};
  CommandAPDU command = new CommandAPDU(0x00, 0xA4, 0x04, 0x00, masterCardRid);
  ResponseAPDU response = channel.transmit(command);
  return response.getData();
}
List<CardTerminal>  terminals   = null; 
TerminalFactory factory         = TerminalFactory.getDefault();
terminals                       = factory.terminals().list();

CardTerminal terminal   = terminals.get(0);
Card card               = terminal.connect("direct");

CardChannel channel     = card.getBasicChannel();

//Read register
byte[] commandAPDU1     = {(byte)0xFF,0x00,0x00,0x00,0x08,  (byte)0xD4, 0x06, 0x63, 0x05, 0x63, 0x0D, 0x63, 0x38 }; 
byte[] responseAPDU1    = card.transmitControlCommand(IOCTL_SMARTCARD_ACR122_ESCAPE_COMMAND, commandAPDU1 );                

System.out.println(bytesToHex(responseAPDU1) + "...");
//Response: D5070707059000...
public boolean selectSector(int sector) throws IOException {
    byte[] cmd_sel1 = { (byte)0xC2, (byte)0xFF };
    byte[] cmd_sel2 = { (byte)sector, (byte)0x00, (byte)0x00, (byte)0x00 };

    byte[] result1 = transceive(cmd_sel1);
    if (result1 == null) {
        throw new TagLostException();
    } else if ((result1.length == 1) && ((result1[0] & 0x00A) == 0x000)) {
        // NACK response according to DigitalProtocol
        return false;
    } else {
        try {
            byte[] result2 = transceive(cmd_sel2);
            if (result2 == null) {
                throw new TagLostException();
            } else if ((result2.length == 1) && ((result2[0] & 0x00A) == 0x000)) {
                // NACK response according to DigitalProtocol
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            // passive ACK
            return true;
        }
    }
}
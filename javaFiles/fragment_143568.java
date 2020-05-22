public interface ScannerInterface extends Library {
    public static class ScannerInfo extends Structure {
        public static class ByReference 
            extends ScannerInfo 
            implements Structure.ByReference {}

        public int count;
        public byte[] host_no = new byte[10];
        public byte[] scsi_id = new byte[10];
    }

    public int GetScannerInfo(ScannerInfo.ByReference scanner);
}
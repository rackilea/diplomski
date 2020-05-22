public static void main(String[] args) throws Exception {
        byte[] data = Files.readAllBytes(Paths.get("path/to/file.ext"));
        Checksum checksum = new CRC32();
        checksum.update(data);
        System.out.println("CRC32 Checksum: "+ checksum.getValue());
    }
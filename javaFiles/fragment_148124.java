public void scanFile(byte[] fileBytes, String fileName)
   throws IOException, Exception {
   if (scan) {
      AVClient avc = new AVClient(avServer, avPort, avMode);
      if (avc.scanfile(fileName, fileBytes) == -1) {
         throw new VirusException("WARNING: A virus was detected in
            your attachment: " + fileName + "<br>Please scan
            your system with the latest antivirus software with
            updated virus definitions and try again.");
      }
   }
}
FileOutputStream os = null;
try {
    os = new FileOutputStream(filePath);
    while (isRecording) {
        // gets the voice output from microphone to byte format
        recorder.read(sData, 0, BufferElements2Rec);
        System.out.println("Short writing to file" + sData.toString());
        try {
            // writes the data to file from buffer stores the voice buffer
            byte bData[] = short2byte(sData);

            os.write(bData, 0, BufferElements2Rec * BytesPerElement);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
} catch (FileNotFoundException e) {
    e.printStackTrace();
} finally {
    if(os != null) {
        try {
            os.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
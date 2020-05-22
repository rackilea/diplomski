protected Boolean doInBackground(String... StringUrls) {
    Boolean success = true;
    len = 0;

    try {
        while (len != -1) {
            bufOutstream.write(buffer, 0, len);
            len = in.read(buffer);

            if (Recorder.this.isCancelled)  {

            Recorder.this.stopSelf();
                break;
            }
        }
    } catch (IOException e) {
            // do something with the exception and if you can't handle it here 
            // rethrow it!
            success = false;
    } finally {
        try {
            bufOutstream.close();
        } catch (Exception e) {
            // do something with the exception and if you can't handle it here 
            // rethrow it!
        }
    }

    return success;
}
} finally {
    if (reader != null)
       try {
           reader.close();
       } catch (IOException e) {
           Log.e(CLASS_NAME, "getPageText.IOException", e);
       }
    }

    try {
        if (conn != null) {
            conn.disconnect();
        }
    } catch (Exception ex) {}
}
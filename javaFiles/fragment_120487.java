ObjectOutputStream objOut = null;
try {
    objOut = new ObjectOutputStream(new FileOutputStream("data.dat"))
    objOut.writeObject(var_1);
    objOut.writeObject(var_2);
} catch (Exception e) {
    Log.e(LOG_TAG, "Could not save data", e);
} finally {
    if (objOut != null) {
        try {
            objOut.close();
        } catch (Exception e) {
            Log.e(LOG_TAG, "Could not close output file", e);
        }
    }
}
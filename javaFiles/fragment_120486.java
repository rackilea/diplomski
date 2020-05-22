try (ObjectOutputStream objOut = new ObjectOutputStream(new
    FileOutputStream("data.dat")))
{
    objOut.writeObject(var_1);
    objOut.writeObject(var_2);
} catch (Exception e) {
    Log.e(LOG_TAG, "Could not save data", e);
}
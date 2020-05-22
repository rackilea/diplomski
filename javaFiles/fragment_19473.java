public static T Load<T>() where T : new()
{
    T loadedUsr = new T();
    string DataFileSave = Settings.Default.savePath + "\\testuserfile.dat";
    FileStream dataStr = new FileStream(DataFileSave, FileMode.Open);
    BinaryFormatter frmtr = new BinaryFormatter();
    loadedUsr = (T) frmtr.Deserialize(dataStr);
    dataStr.Close();
    return loadedUsr;
}

public static void Save<T>(T usr)
{
    string DataFileSave = Settings.Default.savePath + "\\testuserfile.dat";
    File.Delete(DataFileSave);
    FileStream dataStr = new FileStream(DataFileSave, FileMode.Create);
    BinaryFormatter frmtr = new BinaryFormatter();
    frmtr.Serialize(dataStr, usr);
    dataStr.Close();
}
FileHandle propertiesFileHandle = Gdx.files
            .internal(PROPERTIES_FILE_PATH);
PROPERTIES = new Properties();
try {
    PROPERTIES.load(new BufferedInputStream(propertiesFileHandle.read()));
} catch (FileNotFoundException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
}
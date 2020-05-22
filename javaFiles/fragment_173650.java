if (!dbExist) {
    this.getReadableDatabase();
    try {
        CopyDatabase();
    } catch (IOException e) {
        throw new Error("Error.");
    }
}
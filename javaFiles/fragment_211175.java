try {
     conn.extractDocuments(path1);
     updateComplete_DB(getNum);
} catch (Exception e) {
    updateError_DB(getNum);
}
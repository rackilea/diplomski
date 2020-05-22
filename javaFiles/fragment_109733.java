private File caricaimg;
private String caricaimgFileName;
private String caricaimgContentType;

/* getters and setters here */

public String carica() throws SQLException, FileNotFoundException{
    Connessione();   // DB connection method
    System.out.print(caricaimg);

    // not needed -> caricaimg is already a file !!
    // File file = new File(caricaimg);
    // InputStream fin = new java.io.FileInputStream(file);
    // int fileLength = (int)file.length();

    InputStream fin = new java.io.FileInputStream(caricaimg);
    int fileLength = (int)caricaimg.length();
    PreparedStatement pstmt = con.prepareStatement("INSERT INTO Utenti (NomeImg, Immagine) VALUES (?, ?)");

    // not needed -> you already have the fileName
    // pstmt.setString(1, file.getName());

    pstmt.setString(1, caricaimgFileName);
    pstmt.setBinaryStream (2, fin, fileLength);
    pstmt.executeUpdate();

    // DON'T FORGET TO CLOSE THE STREAM !!
    fin.close();
    // ---------

    return "success";
}
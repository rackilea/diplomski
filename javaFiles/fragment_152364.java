public String getBinaryToString(String columna){
    try {
            java.io.InputStream is = resultados.getBinaryStream(columna);
            int intValueOfChar;
            String targetString = "";
            while ((intValueOfChar = is.read()) != -1) {
                targetString += (char) intValueOfChar;
            }
            is.close();
            return targetString;
        } catch (SQLException | IOException ex) {
            Logger.getLogger(Base.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
}
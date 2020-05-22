public ArrayList<Files> getFiles(int folderid, int userid) throws SQLException, ClassNotFoundException {
    ArrayList<Files> fileList = new ArrayList<Files>();

    PreparedStatement preparedStatement = DatabaseConnection.getDatabase().getConnection()
            .prepareStatement(GET_FILES_QUERY);
    preparedStatement.setInt(1, folderid);
    preparedStatement.setInt(2, userid);
    ResultSet resultSet = preparedStatement.executeQuery();

    while (resultSet.next()) {
        Files file = new Files();
        file.setFileid(resultSet.getInt("id"));
        file.setFolderid(resultSet.getInt("folderid"));
        file.setFilename(resultSet.getString("filename"));
        file.setCreateddate(convertDate(resultSet.getString("createddate")));
        file.setFile(resultSet.getString("file"));
        file.setLastmodified(convertDate(resultSet.getString("lastmodified")));
        file.setExtension(extractExtension(resultSet.getString("file")));
        file.setIcon(getIcon(extractExtension(resultSet.getString("file"))));
        file.setUserid(userid);

        fileList.add(file);
    }

    close(preparedStatement, resultSet);

    return fileList;
}
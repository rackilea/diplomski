String update = "UPDATE salesforce.Employee__c SET First_Name__c = ?, Last_Name__c = ?, Email__c = ? WHERE Id = ? ";
try (PreparedStatement pstm = connection.prepareStatement(update)) {
    pstm.setString(1, e.getFirst());
    pstm.setString(2, e.getLast());
    pstm.setString(3, e.getEmail());
    pstm.setInt(4, id);

    pstm.executeUpdate();
}
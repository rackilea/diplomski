int j = 1;
for (int i = 0; i < arrCertificates.size(); ++i) {
    preparedStmt.setInt(j++, arrCertificates.get(i).getCertificateTypeID());
    preparedStmt.setInt(j++, arrCertificates.get(i).getContratoID());
    preparedStmt.setString(j++, arrCertificates.get(i).getFolio());
    preparedStmt.setInt(j++, Integer.parseInt(arrCertificates.get(i).getID()));
}
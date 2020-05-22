sql.append("SELECT MatterDataset.id  ");
//Removed rest of selection items for readability and to focus the inquiry

sql.append(" FROM MatterDataset, DocumentClassification, PrivilegeLog  " ) ; //<--NOT A PROBLEM LINE
sql.append(" WHERE    " ) ;
sql.append("   MatterDataset.id = DocumentClassification.matterid  " ) ;
sql.append("   AND MatterDataset.id = PrivilegeLog.matterid   " ) ;
sql.append("   AND DocumentClassification.id = PrivilegeLog.documentparentid    " ) ;
sql.append("   AND Matterdataset.id = ? " ) ; //Prepared statement
sql.append("   AND Matterdataset.isdeleted = 0  " ) ;
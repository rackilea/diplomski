QueryStatement stmt = session.createQueryStatement("IN_FOLDER(?) AND cmis:contentStreamMimeType=?");
stmt.setString(1, target.getId());
stmt.setString(2, "application/pdf");

ItemIterable<CmisObject> documents = session.queryObjects("cmis:document", stmt.toString(), false, session.getDefaultContext());

for (CmisObject cmisObject: documents)
{
  finalDocumentList.add((Document)cmisObject);
}
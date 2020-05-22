Uri treeUri = data.getData();
DocumentFile pickedDir = DocumentFile.fromTreeUri(MainActivity.this, treeUri);
DocumentFile documentFile = pickedDir.findFile("Note");
if (documentFile == null) 
  documentFile = pickedDir.createFile("text/plain", "Note");

OutputStream out = getContentResolver().openOutputStream(documentFile.getUri());                                            
out.write(infos.get(i).getContent().getBytes());
out.flush();
out.close();
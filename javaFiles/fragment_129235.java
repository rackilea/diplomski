session = NotesFactory.createSession(DOMINO_SERVER, DOMINO_USER, DOMINO_PW);
if ( session == null ) {
//do something
}
DbDirectory dir = session.getDbDirectory(null);
db = dir.openDatabase(DOMINO_DATABASE);
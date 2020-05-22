for (Iterator entries = logEntries.iterator(); entries.hasNext();) {
   /*
    * gets a next SVNLogEntry
    */
    SVNLogEntry logEntry = (SVNLogEntry) entries.next();
    int revisionNumber = logEntry.getRevision();

    if(revisionNumber => 3 && revisionNumber <= 7) {

        System.out.println("____________________________________________________");
       /*
        * gets the revision number
        */
       System.out.println("Revision: " + revisionNumber);
       /*
        * gets the author of the changes made in that revision
        */
       System.out.println("Author: " + logEntry.getAuthor()); 
    }
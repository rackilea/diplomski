Session s = NotesFactory.createSessionWithFullAccess("Password");
//or
Session s = NotesFactory.createSession(null, "", "");
//or
Session s = NotesFactory.createSession(hostString, HttpServletRequest);
//etc
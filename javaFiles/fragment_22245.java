SVNRepository repository = SVNRepositoryFactory.create(url);

ISVNAuthenticationManager authManager = SVNWCUtil.createDefaultAuthenticationManager(user,password);
repository.setAuthenticationManager(authManager);

SVNPropertyValue svnPropertyValue = SVNPropertyValue.create("def");
ISVNEditor editor = repository.getCommitEditor("comment", null);
editor.openRoot(-1);
editor.openDir("dirname", -1);
editor.changeDirProperty("myproperty", svnPropertyValue);
editor.closeEdit();
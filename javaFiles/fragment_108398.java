final existingCl = server.getChangelist( changeListNumber )
cl = new Changelist( 
        IChangelist.UNKNOWN,
        ... snip ...
    );
cl = client.createChangelist(cl);
cl.fileSpecs = mergeChangeListToBranch( client, cl, ...
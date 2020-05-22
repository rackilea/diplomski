Iterator<TvAppsType> itertypes = apptypes.iterator();
while (itertypes.hasNext()) {
    TvAppsType apptype = itertypes.next();
    Iterator<ThreatviewApp> it = apps.iterator(); // the inner iterator must be
                                                  // initialized in each iteration
                                                  // of the outer loop
    while (it.hasNext()) {
        ...
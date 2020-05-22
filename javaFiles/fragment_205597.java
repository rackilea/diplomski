private void readData() {
        searchResults = new LDAPSearchResults();
        try {
            Thread.sleep(450);
        } catch (InterruptedException ex) {
            Logger.getLogger(Profylaxia.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            searchResults = lc.search(searchBase, searchScope, searchFilter, null, false);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Profylaxia.class.getName()).log(Level.SEVERE, null, ex);
            }
            int noResult = searchResults.getCount();
            System.out.println("  noResult : " + noResult);
IJavaSearchScope scope = SearchEngine.createJavaSearchScope(new IJavaElement[] { yourProject });
        //IJavaSearchScope scope = SearchEngine.createWorkspaceScope(); // Use this if you dont have the IProject in hand
        SearchPattern searchPattern = SearchPattern.createPattern(field,
                IJavaSearchConstants.REFERENCES);
        SearchRequestor requestor = new SearchRequestor() {
            @Override
            public void acceptSearchMatch(SearchMatch match) {
                System.out.println(match.getElement());
            }
        };
        SearchEngine searchEngine = new SearchEngine();
        searchEngine.search(searchParttern,
                new SearchParticipant[] { SearchEngine.getDefaultSearchParticipant() }, scope,
                requestor, new NullProgressMonitor());
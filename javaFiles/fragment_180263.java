IWorkspace workspace = ResourcesPlugin.getWorkspace();
    IWorkspaceRoot root = workspace.getRoot();
    IProject plainProject = root.getProject("some project");
    IJavaProject javaProject = JavaCore.create(plainProject);
    try {
        IType type = javaProject.findType("foo.bar.AnotherClass");
        IField field = type.getField("z");
        //IJavaSearchScope scope = SearchEngine.createWorkspaceScope();
        IJavaSearchScope scope = SearchEngine.createJavaSearchScope(new IJavaElement[] { plainProject });
        SearchPattern searchParttern = SearchPattern.createPattern(field,
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
    } catch (Exception e) {
        // some exception handling you need to do
    }
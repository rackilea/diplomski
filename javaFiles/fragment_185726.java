@Override
    protected Class<?>[] setAnotatedClasses() {
        Class<?>[] superClasses = super.setAnotatedClasses(sessionFactory);
        Class<?>[] childClasses = new Class<?>[]{RepositoryList.class, UrlRepository.class};
        Class<?>[] allClasses = new Class<?>[childClasses.length + superClasses.length]; 
        for (int i = 0; i < allClasses.length; i++) {
            if (i < superClasses.length)
                allClasses[i] = superClasses[i];
            else
                allClasses[i] = childClasses[i-childClasses.length];
        }
        return allClasses;
    }
GlobalSearchScope scope = GlobalSearchScope.allScope(project);
    PsiClass psiClass = JavaPsiFacade.getInstance(project).findClass("org.myPackage.MyClass", scope);

    if ( psiClass != null ) {
        FileEditorManager fileEditorManager = FileEditorManager.getInstance(project);
        fileEditorManager.openFile(psiClass.getContainingFile().getVirtualFile(), true, true);
    } else {
        //handle the class not found
    }
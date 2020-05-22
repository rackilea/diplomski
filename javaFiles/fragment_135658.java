GlobalSearchScope scope = GlobalSearchScope.allScope(project);
    PsiClass psiClass = JavaPsiFacade.getInstance(project).findClass(className, scope);

    if (psiClass != null) {
        FileEditorManager fileEditorManager = FileEditorManager.getInstance(project);
        //Open the file containing the class
        VirtualFile vf = psiClass.getContainingFile().getVirtualFile();
        //Jump there
        new OpenFileDescriptor(project, vf, 1, 0).navigateInEditor(project, false);
    } else {
        //Handle file not found here....
        return;
    }
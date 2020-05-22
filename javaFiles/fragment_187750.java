String id = IJavaRefactorings.RENAME_METHOD;
RefactoringContribution contrib = RefactoringCore.getRefactoringContribution(id);
RenameJavaElementDescriptor desc = contrib.createDescriptor();
desc.setUpdateReferences(true);
desc.setJavaElement(methodToRename);
desc.setNewName(newName);
desc.createRefactoring(status);
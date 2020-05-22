IFile file = ...

IJavaElement element = JavaCore.create(file); 

if (element instanceof ICompilationUnit) {
  ICompilationUnit compUnit = (ICompilationUnit)element;

  ...
}
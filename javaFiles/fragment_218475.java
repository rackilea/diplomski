public static List<MethodInformation>  calculate(IJavaProject project) {
  List<MethodInformation> list = new ArrayList<MethodInformation>();
  try {
    if (project.isOpen()) {
      IPackageFragment[] packages = project.getPackageFragments();
      // parse(JavaCore.create(project));
      for (IPackageFragment mypackage : packages) {
        if (mypackage.getKind() == IPackageFragmentRoot.K_SOURCE) {
          for (ICompilationUnit unit : mypackage.getCompilationUnits()) {
             IType[] types = unit.getTypes();
             for (int i = 0; i < types.length; i++) {
               IType type = types[i];
               IMethod[] methods = type.getMethods();
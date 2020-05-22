CallHierarchyGenerator callGen = new CallHierarchyGenerator();

    IMethod m = findMethod(type, "world");
    Set<IMethod> methods = new HashSet<IMethod>();
    methods = callGen.getCallersOf(m);
    for (Iterator<IMethod> i = methods.iterator(); i.hasNext();)
    {
        System.out.println(i.next().toString());
    }
BindingScopingVisitor<Boolean> visitor = new IsSingletonBindingScopingVisitor();
    Map<Key<?>, Binding<?>> bindings = injector.getAllBindings();
    for (Binding<?> binding : bindings.values()) {
        Key<?> key = binding.getKey();
        System.out.println("Examing key "+ key);

        Boolean foundSingleton = binding.acceptScopingVisitor(visitor);
        if( foundSingleton ) {
            Object instance = injector.getInstance(key);
            System.out.println("\tsingleton: " + instance);
        }
    }

class IsSingletonBindingScopingVisitor implements BindingScopingVisitor<Boolean> {
    @Override
    public Boolean visitEagerSingleton() {
        System.out.println("\tfound eager singleton");
        return Boolean.TRUE;
    }

    @Override
    public Boolean visitScope(Scope scope) {
        System.out.println("\t scope: "+scope);
        return scope == Scopes.SINGLETON;
    }

    @Override
    public Boolean visitScopeAnnotation(Class<? extends Annotation> scopeAnnotation) {
        System.out.println("\t scope annotation: "+scopeAnnotation);
        return scopeAnnotation == Singleton.class;
    }

    @Override
    public Boolean visitNoScoping() {
        return Boolean.FALSE;
    }
}
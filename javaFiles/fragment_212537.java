private static class ScopeValidator implements ProvisionListener {
    private @Inject Injector injector;
    private @Inject WhateverScope scope;

    @Override
    public <T> void onProvision(ProvisionInvocation<T> provision) {
        if (injector == null) {
            // The injector isn't created yet, just return. This isn't a
            // problem because any scope violations will be caught by
            // WhateverScope itself here (throwing an OutOfScopeException)
            return;
        }

        Binding<?> binding = provision.getBinding();
        Key<?> key = binding.getKey();

        if (Scopes.isSingleton(binding) && binding instanceof HasDependencies) {
            Set<Dependency<?>> dependencies = ((HasDependencies) binding).getDependencies();

            for (Dependency<?> dependency : dependencies) {
                Key<?> dependencyKey = dependency.getKey();
                Binding<?> dependencyBinding = injector.getExistingBinding(dependencyKey);

                if (dependencyBinding != null && Scopes.isScoped(dependencyBinding, whateverScope, WhateverScoped.class)) {
                    throw new ProvisionException(String.format(
                            "Singleton %s depends on @WhateverScoped %s",
                            key, dependencyKey));
                }
            }
        }
    }
}
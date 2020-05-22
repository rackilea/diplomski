DependencySelector depFilter =
            new AndDependencySelector(
                    new ScopeDependencySelector( "provided" ),
                    new OptionalDependencySelector(),
                    new ExclusionDependencySelector()
            );
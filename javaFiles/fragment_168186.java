package di.failure.example;

import javax.inject.Singleton;

@Singleton
public class DependencyImpl implements Dependency {
    @Override
    public void run() {
        throw new RuntimeException("I don't want this to load!");
    }
}
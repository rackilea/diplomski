package di.failure.example;

import javax.inject.Singleton;

@Singleton
public class Dependency {

    public Dependency() {
        System.out.println("Dependency.<init>");
    }

    void run() {
        throw new RuntimeException("I don't want this to load!");
    }
}
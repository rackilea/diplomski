package di.failure.example;

import io.micronaut.context.annotation.Replaces;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.inject.Singleton;

@MicronautTest
public class ClassUnderTestTest {

    @Inject
    ClassUnderTest classUnderTest;

    @Test
    public void test() {
        classUnderTest.run();
    }

    @Replaces(Dependency.class)
    @Singleton
    public static class MockDependency extends Dependency {

        public MockDependency() {
            System.out.println("MockDependency.<init>");
        }

        @Override
        void run() {
            System.out.println("Does not throw any exception...");
        }
    }
}
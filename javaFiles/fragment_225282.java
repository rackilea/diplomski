import static java.util.Collections.*;
import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.TypeLiteral;
import com.google.inject.multibindings.Multibinder;

public class GuiceWildcardTest {

    @Test public void binderShouldBindClassWithWildcard() {
        final ClassHolder holder = new ClassHolder();
        Guice.createInjector(new AbstractModule() {
            @Override protected void configure() {
                bind(new TypeLiteral<Class<? extends SuperClass>>() {}).toInstance(SubClass.class);
                requestInjection(holder);
            }
        });
        assertEquals(SubClass.class, holder.type);
    }

    @Test public void multibinderShouldBindSetOfClassesWithWildcard() {
        final SetHolder holder = new SetHolder();
        Guice.createInjector(new AbstractModule() {
            @Override protected void configure() {
                Multibinder.newSetBinder(binder(), new TypeLiteral<Class<? extends SuperClass>>() {}).addBinding().toInstance(SubClass.class);
                requestInjection(holder);
            }
        });
        assertEquals(singleton(SubClass.class), holder.types);
    }

    static class SuperClass {}

    static class SubClass extends SuperClass {}

    static class ClassHolder {
        @Inject Class<? extends SuperClass> type;
    }

    static class SetHolder {
        @Inject Set<Class<? extends SuperClass>> types;
    }
}
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.inject.Provider;

import com.google.inject.AbstractModule;
import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.name.Names;
import com.google.inject.spi.Dependency;
import com.google.inject.spi.ProviderInstanceBinding;
import com.google.inject.spi.ProviderWithDependencies;

class FirstItemProvider<T> implements ProviderWithDependencies<T> {
    private final Provider<? extends Collection<? extends T>> collectionProvider;
    private final Key<? extends Collection<? extends T>> key;

    public FirstItemProvider(Binder binder, Key<? extends Collection<? extends T>> key) {
        this.collectionProvider = binder.getProvider(key);
        this.key = key;
    }

    @Override
    public T get() {
        return collectionProvider.get().iterator().next();
    }

    @Override
    public Set<Dependency<?>> getDependencies() {
        return Collections.<Dependency<?>>singleton(Dependency.get(key));
    }
}

class FooModule extends AbstractModule {
    @Override
    protected void configure() {
        Key<List<String>> listKey = new Key<List<String>>(Names.named("foo")){};
        Key<String> stringKey = new Key<String>(Names.named("foo")){};

        bind(listKey).toInstance(Arrays.asList("foo", "bar"));
        bind(stringKey).toProvider(new FirstItemProvider<>(binder(), listKey));
    }
}

public class Foo {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new FooModule());

        Key<String> stringKey = new Key<String>(Names.named("foo")){};
        ProviderInstanceBinding<String> binding = (ProviderInstanceBinding<String>)injector.getBinding(stringKey);
        System.out.println(binding.getDependencies());
    }
}
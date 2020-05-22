import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.checkerframework.framework.qual.FieldInvariant;

class Parent {

  final @Nullable String name;

  Parent(@Nullable String name) {
    this.name = name;
  }

  Driver createDriver() {
    return new CommonDriver(name);
  }
}

@FieldInvariant(qualifier = NonNull.class, field = "name")
class ChildC extends Parent {

  ChildC(@NonNull String name) {
    super(name);
  }

  @Override
  Driver createDriver() {
    return new ChildCDriver(name);
  }
}

interface Driver {}

class CommonDriver implements Driver {
  CommonDriver(@Nullable String name) {}
}

class ChildCDriver implements Driver {
  ChildCDriver(@NonNull String name) {}
}
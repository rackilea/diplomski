public interface MySuperInterface {
  <T> T acceptVisitor(MySuperInterfaceVisitor<T>);
}

public interface MySuperInterfaceVisitor<T> {
  T visitA(SubclassA a);
  T visitB(SubclassB a);
}

public class SubclassA implements MySuperInterface {
  <T> T acceptVisitor(MySuperInterfaceVisitor<T> visitor) {
    return visitor.visitA(this);
  }
}

public class SubclassB implements MySuperInterface {
  <T> T acceptVisitor(MySuperInterfaceVisitor<T> visitor) {
    return visitor.visitB(this);
  }
}

public class MySuperHandler implements MySuperInterfaceVisitor<Foo>{
  Foo visitA(SubclassA a) {
    // construct Foo from SubclassA instance
  }

  Foo visitB(SubclassB a) {
    // construct Foo from SubclassB instance
  }
}
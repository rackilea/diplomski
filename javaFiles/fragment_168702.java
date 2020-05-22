class Base {
    class inner {
    }
}

class X extends Base {
    class A extends inner {
    }

    class B extends inner {
    }
}

class Y extends Base {
    class A extends inner {
    }

    class B extends inner {
    }
}

<T extends Base> Base make(T.inner... inner) {
    ...
}
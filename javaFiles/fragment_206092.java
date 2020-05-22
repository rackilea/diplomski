public void foo() {
    // ...
    CommonInterface obj = newInstance(module);
    obj.run(hashMapContext);
    // ...
}

public CommonInterface newInstance(module) {
    switch (module) {
        case A:
            return ClassFromModuleA;
        case B:
            return ClassFromModuleB;
        // ...
    }
}
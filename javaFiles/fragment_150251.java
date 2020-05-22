java configuration LcJavaMain {
    project com.wamas.test;
    main-class com.wamas.test.JavaMain;

    memory min=64m max=256m;

    vm-argument '-Dmy.arg=value';
    argument 'cmdArg';
}
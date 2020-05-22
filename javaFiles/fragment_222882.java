void setFooArray(ArrayList<Foo> param) {
    Foo[] fooArray = new Foo[param.size()];

    for (int i = 0; i < param.size(); i++) {
        fooArray[i] = param.get(i);
    }

    native_setFooArray(fooArray, fooArray.length);
}

// ...

private native void native_setFooArray(Foo[] fooArray, int size);
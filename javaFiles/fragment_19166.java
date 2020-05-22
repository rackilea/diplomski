void performDoSomething(ABC abc, String path, String[] strList){
    def list = []
    for (str in strList) {
        SomeObject sObj = new SomeObject(str)    // EDIT: sorry I missed this line before
        list.add(sObj)
    }
    if (abc) abc.doSomething(path, list)
}

performDoSomething(new ABC(), 'some path', ['hello', 'world'] as String[])
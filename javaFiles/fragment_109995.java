interface IMyClass {
    var myClassList: ArrayList<IMyClass>
}

class MyClassOne {
    companion object : IMyClass{
        override var myList: ArrayList<IMyClass>
            get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
            set(value) {}
    }
}

class MyClassTwo {
companion object : IMyClass{
        override var myList: ArrayList<IMyClass>
            get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
            set(value) {}
    }
}
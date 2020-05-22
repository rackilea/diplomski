@objc private class notAnAnonButPrivateClass : NSObject, Executer
{
    let executeImpl : () -> Void

    init(_ theImpl : @escaping () -> Void)
    {
        executeImpl = theImpl
    }

    func execute() -> Void
    {
        executeImpl()
    }
}

var executer : Executer = notAnAnonButPrivateClass() {
    print("we did it again!")
}
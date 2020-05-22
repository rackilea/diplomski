class A {

    var name : String
    var startable : ((String) -> Int)?

    init(_ name : String, _ startable : ((String) -> Int)?) {
        self.name = name
        self.startable = startable
    }

    func doSometing() {
        if let fn = startable {
           fn(name)
        }
    }   
}
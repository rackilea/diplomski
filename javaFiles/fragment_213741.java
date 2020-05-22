class A {
    def name
    static hasOne = [b:B]
    static constraints = { 
        // b unique: true <-- REMOVED
        name unique: true
    }
}

class B {
    A a
    static belongsTo = [A]
    static constraints = {
        a unique: true // <-- ADDED
    }
}
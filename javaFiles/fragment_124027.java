class Job {
    class Store: Equatable {
        let salary: Int

        @private init(_ salary:Int) { // hope Swift will have private accessors one day
            self.salary = salary
        }

        func atack() ->() {}

    }

    class var NINJA: Store {
        class Ninja: Store {
            override func atack() ->() {
                println("Attack with shuriken.")
            }
        }
        return Ninja(3000000)
    }

    class var SAMURAY: Store {
        class Samuray: Store {
            override func atack() ->() {
                println("Attack with sword.")
            }
        }
        return Samuray(4000000)
    }

    class func CUSTOM(salary: Int) -> Store {
        return Store(salary)
    }
}

func == (lhs: Job.Store, rhs: Job.Store) -> Bool {
    return lhs.salary == rhs.salary
}
class BasicDBObject extends HashMap { }

class Mongo {
    def save(BasicDBObject obj) {
        println "saving $obj"
    }
}

def mongo = new Mongo()

// here it will fail
try {
    mongo.save uno:1, dos:2
    assert false
} catch (e) { }


mongo.metaClass.save = { Map map -> delegate.save( map as BasicDBObject ) }

// and here it succeeds ;-)
mongo.save uno:1, dos:2
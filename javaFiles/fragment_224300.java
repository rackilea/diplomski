object Factory {
    val SERVER = "<some server>"
    val DATABASE = "<some database>"
    val connectionMongo = MongoConnection(SERVER)(DATABASE)
    def getCollection(name: String) = connectionMongo(name)
}
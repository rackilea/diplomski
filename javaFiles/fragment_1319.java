class MyController {
    SessionFactory sessionFactory

    def deleteStoresFromAuthor(Author author) {
        author.stores.each { it.delete(flush: true) }
    }

    def deleteStoresFromAuthorWithDelayedFlush(Author author) {
        author.stores.each { it.delete() }
        sessionFactory.currentSession.flush()
    }

    def createStoreForAuthor(Author author) {
        new Store(author: author, dateCreated: new Date(), lastUpdated: new Date()).
                save(flush: true)
    }
}
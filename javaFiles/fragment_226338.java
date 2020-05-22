fun insert(book: Book) : Book? {
    getByEan(book.EAN)?.let {
        return null
    }
    return book.apply { mongo.collection.insertOne(book) }
}

data class Book(val name: String, val EAN: Int, val author: String, val _id: String? = null)
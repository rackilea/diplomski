// old code
void doSomething( String bookType )
{
    if (bookType.equals("BOOK")
    {
        // do something with book
    }
    else if (bookType.equals("MAGAZINE")
    {
        // do something with magazine
    }
    // OOPS, this code is broken if someone adds a new type of book, or uses the string "Book" or "book"
}

// new code
void doSomething( BookEnum bookType )
{
    switch (bookType)
    {
         // cases for each enum value
    }
}
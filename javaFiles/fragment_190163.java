class Course
  {
    @XmlElement (name = "book")
    List<Book> requiredBooks = new ArrayList<Book>();  
    ...
    void afterUnmarshal(Unmarshaller aUnmarshaller, Object aParent)
    {
        if (requiredBooks != null)
        {
            Iterator<Book> iterator = requiredBooks.iterator();
            while (iterator.hasNext())
            {
                Book book = iterator.next();
                if (StringUtils.isEmpty(book.getTitle()))
                {
                    // a book without title is considered invalid
                    iterator.remove();
                }
            }
        }
    }
  }
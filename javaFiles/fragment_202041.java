@RequestMapping(value = "/books", method = RequestMethod.GET)
public String listBooks(@RequestParam("personId") String personId, 
                        Model model) {    

    Criteria query = session.createCriteria(Person.class);
    query.addRestriction("personId", personId);
    Person me = query.list().get(1);
    List<Book> myBooks = me.getBooks();
    model.setAttribute("person", me);
    model.setAttribute("books", myBooks);
    return "view/books";
}
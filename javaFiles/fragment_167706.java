import org.springframework.hateoas.Resource;

    // ...

    @RequestMapping(method = RequestMethod.POST,value = "/books")
    public @ResponseBody PersistentEntityResource post(
        @RequestBody Resource<Book> bookResource,             // Resource<Book>
        PersistentEntityResourceAssembler assembler) {

        Book book = bookResource.getContent()
        // ...
    }
public String addAuthor(Author author) {
    if(authorRepository.existsByFirstNameAndLastName(author.getFirstName(),author.getLastName())){
        return "Author or Author ID Already Exists";
    }
    else{
        authorRepository.save(author);
        return "Created";
    }
}
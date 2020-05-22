public String updateAuthor(Author author) {
    if(authorRepository.existsByIdAndFirstNameAndLastName(author.getId(),author.getFirstName(),author.getLastName())){
        return "Author or Author ID Already Exists";
    }
    else{
        Author existingAuthor = authorRepository.findByID(author.getID());// you will have to check as per your spring hibernate versions, as this will vary as per versions
        existingAuthor.setFirstName(author.getFirstName()); // updating the FirstName field
        existingAuthor.setLastName(author.getLastName()); // updating the LastName field
        authorRepository.update(existingAuthor); // use appropriate method here it could be merge or update, depends on the type of configuration
        return "Updated";
    }
}
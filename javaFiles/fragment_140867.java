class Document {
    @Id
    Long id;

    @OneToMany
    List<Attachment> attachments;
}

class Article extends Document {
    //....
}

class Book extends Document {
    //....
}
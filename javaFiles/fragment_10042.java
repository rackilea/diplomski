class User {
       @OneToMany
       List<File> ownFiles;

       @ElementCollection
       Map<File, Integer> sharedFiles; 
}

class File {
       @ManyToOne
       User author;

       @ElementCollection
       Map<User, Integer> sharedUsers;
}
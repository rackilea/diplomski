class User {
       @OneToMany
       @JoinTable(name = "USER_HAS__OWN_FILES", joinColumns = {
       @JoinColumn(name = "AUTHOR", referencedColumnName = "USERNAME")}, 
            inverseJoinColumns = {@JoinColumn(name = "OWN_FILE_ID", referencedColumnName = "ID") })
       List<File> ownFiles;

       @ElementCollection
       @CollectionTable(name = "USER_HAS_SHARED_FILES", joinColumns = 
       @JoinColumn(name = "USERNAME", referencedColumnName = "USERNAME"))
       @MapKeyJoinColumn(name = "SHARED_FILE_ID", referencedColumnName = "ID")
       @Column(name = "PERMISSION_LEVEL")
       Map<File, Integer> sharedFiles; 
}

class File {
       @ManyToOne
       @JoinColumn(name = "FILE_AUTHOR", referencedColumnName = "USERNAME")
       User author;

       @ElementCollection
       @CollectionTable(name = "FILE_HAS_BEEN_SHARED_TO_USER", 
           joinColumns = @JoinColumn(name = "FILE_ID", referencedColumnName = "ID"))
       @MapKeyJoinColumn(name = "USER_THAT_FILE_HAS_BEEN_SHARED_TO", referencedColumnName = "USERNAME")
       @Column(name = "PERMISSION_LEVEL")
       Map<User, Integer> sharedUsers;
}
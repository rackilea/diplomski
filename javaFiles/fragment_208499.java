class Department{
...
@OneToOne (fetch = FetchType.LAZY, 
    cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
Content content = new Content();
...
}


class Content{
...
@Column(columnDefinition = "TEXT")
@Basic(fetch = FetchType.LAZY)
String htmlBody;
...
}
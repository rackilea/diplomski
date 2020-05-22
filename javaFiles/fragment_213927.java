@Id
@Column(name = "BOOK_ID", insertable = false, updatable = false)
private long bookId;

@Id
@Column(name = "BORROWER_ID", insertable = false, updatable = false)
private long borrowerId;

@MapsId("bookId")
@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,
                                              CascadeType.MERGE,
                                              CascadeType.REFRESH})
@JoinColumn(name = "BOOK_ID")
private Book book;

@MapsId("borrowerId")
@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, 
                                               CascadeType.MERGE,
                                               CascadeType.REFRESH})
@JoinColumn(name = "BORROWER_ID")
private Borrower borrower;

@Id
@Column(name = "BORROW_DATE")
private Date borrowDate;
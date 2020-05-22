//not nullable
@Column(nullable = false)
private String prop1;

//nullable
@Column(nullable = true)
private String prop2;

//default = nullable
@Column
private String prop3;
@Id
 @GeneratedValue(strategy = GenerationType.TABLE)
 private Integer id;

 @Version
 @Column(name = "opt_lock")
 private Integer version;

 @OneToMany(orphanRemoval = false)
 @OrderColumn(name = "order_jueces")
 private List<Juez> rol;
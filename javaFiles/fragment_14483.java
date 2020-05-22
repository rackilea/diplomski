@Enumerated(EnumType.STRING)
@ElementCollection(targetClass = TypeForm.class, fetch = FetchType.LAZY)
@CollectionTable(name = "AssoReadRight_Form", joinColumns = {@JoinColumn(name = "idProfil", nullable = false, referencedColumnName = "idProfil"),
        @JoinColumn(name = "idState", nullable = false, referencedColumnName = "idState")})
@Column(name = "typeForm")
private Set<TypeForm> formulairesLecture;

@Enumerated(EnumType.STRING)
@ElementCollection(targetClass = TypeForm.class, fetch = FetchType.LAZY)
@CollectionTable(name = "AssoWriteRight_Form", joinColumns = {@JoinColumn(name = "idProfil", nullable = false, referencedColumnName = "idProfil"),
        @JoinColumn(name = "idState", nullable = false, referencedColumnName = "idState")})
@Column(name = "typeForm")
private Set<TypeForm> formulairesEcriture;
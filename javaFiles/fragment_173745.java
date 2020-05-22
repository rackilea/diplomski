@JsonIgnore
@ElementCollection(fetch = FetchType.LAZY)
@CollectionTable(name = "FTT_REGISTRI_ESCLUSIONI", foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "FTT_FK_ESCLUSIONE_TO_REGISTRO"), joinColumns = @JoinColumn(name = "REGISTRO_ID"))
@MapKeyColumn(name = "CLAUSOLA_ESCLUSIONE", length = 40, nullable = false)
@MapKeyClass(FttEsclusioneType.class)
@MapKeyEnumerated(EnumType.STRING)
@Column(name = "RECORD_COUNT", nullable = false)
protected final Map<FttEsclusioneType, Long> esclusioneRecordCounters = new HashMap<>();
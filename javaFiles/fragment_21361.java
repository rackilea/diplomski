@Entity
class Uncertainty {

// Do I need fields here to represent the composite primary key (containerId, data_field)?

@Id
private int id;

@Column
private BigDecimal maximum;

@Column
private BigDecimal upside;

@Column
private BigDecimal reference;

@Column
private BigDecimal downside;

@Column
private BigDecimal minimum;
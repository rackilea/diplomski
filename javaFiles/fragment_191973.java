@Column(name = "value")
private int intValue;

@Transient
private Double value = null;

public double getValue() {
     if (value == null)
         value = intValue;
     return value;
}

public void setValue(double value) {
     this.value = value;
     this.intValue = value;
}
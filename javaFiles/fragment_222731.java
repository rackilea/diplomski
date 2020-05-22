private List<String> values = new ArrayList<>();

@JsonAnySetter
public void setValues(String key, String value) {
  // You can perform a pattern validation on the key if wanted
  this.values.add(value);
}

public List<String> getValues() {
  return this.values;
}
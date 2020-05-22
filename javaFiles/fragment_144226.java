// ensure that "id" and "name" are output before other properties
@JsonPropertyOrder({ "id", "name" })
// order any properties that don't have explicit setting using alphabetic order

@JsonPropertyOrder(alphabetic=true)
//This annotation may or may not have effect on deserialization: for basic JSON handling there is no effect, but for other supported data types (or structural conventions) there may be.
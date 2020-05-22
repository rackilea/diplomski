public XmlTextNode convert(Item item) {
    if (item instanceof ConcreteItem) {
        return new ConcreteConverter(item).getResult();
    }
    throw new InvalidOperationException("Invalid convert type");
}
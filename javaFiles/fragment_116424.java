XmlWriter writer = new XmlWriter();
writer.writeHeader();
for (Item item : xmlitems) {
    writer.write(convert(item));
}
writer.close();
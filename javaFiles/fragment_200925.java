public void setAddAttribute(PersonAttribute attribute){
    if (attribs == null){
        attribs = new ArrayList<PersonAttribute>();
    }
    attribs.add(attribute);
}
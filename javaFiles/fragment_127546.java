{
    ...
    for (int i = 0; i < fields.length; i += 2)
        fields[i] = fields[i + 1] = new Field(r.nextInt(pool));

    shuffleFields(fields);

    return fields;
}
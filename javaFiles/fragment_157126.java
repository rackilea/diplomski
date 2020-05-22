Mp4FieldKey(String issuer, String identifier, Mp4FieldType fieldType, Tagger tagger)
    {

        this.issuer = issuer;
        this.identifier = identifier;
        this.fieldName = Mp4TagReverseDnsField.IDENTIFIER + ":" + issuer + ":" + identifier;
        this.subclassType = Mp4TagFieldSubType.REVERSE_DNS;
        this.fieldType = fieldType;
        this.tagger = tagger;
    }
TypeName wildcard = WildcardTypeName.subtypeOf(Object.class);
    TypeName classOfAny = ParameterizedTypeName.get(
            ClassName.get(Class.class), wildcard);
    FieldSpec field = FieldSpec.builder(classOfAny, "mClass")  // You may consider using a constant here
            .addModifiers(Modifier.PRIVATE, Modifier.FINAL)
            .build();

    servicesEnumBuilder.addField(field);
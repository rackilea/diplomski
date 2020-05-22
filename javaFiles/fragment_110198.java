// iterate through the fields and see wether or not they should be mapped
    // one way class mappings we do not need to add any fields
    if (!MappingDirection.ONE_WAY.equals(classMap.getType())) {
      for (FieldMap fieldMap : fms.toArray(new FieldMap[]{})) {
        fieldMap.validate();

        // If we are dealing with a Map data type, transform the field map into a MapFieldMap type
        // only apply transformation if it is map to non-map mapping.
        if (!(fieldMap instanceof ExcludeFieldMap)) {
          if ((isSupportedMap(classMap.getDestClassToMap())
                  && !isSupportedMap(classMap.getSrcClassToMap()))
              || (isSupportedMap(classMap.getSrcClassToMap())
                  && !isSupportedMap(classMap.getDestClassToMap()))
              || (isSupportedMap(fieldMap.getDestFieldType(classMap.getDestClassToMap()))
                  && !isSupportedMap(fieldMap.getSrcFieldType(classMap.getSrcClassToMap())))
              || (isSupportedMap(fieldMap.getSrcFieldType(classMap.getSrcClassToMap())))
                  && !isSupportedMap(fieldMap.getDestFieldType(classMap.getDestClassToMap()))) {
            FieldMap fm = new MapFieldMap(fieldMap);
            classMap.removeFieldMapping(fieldMap);
            classMap.addFieldMapping(fm);
            fieldMap = fm;
          }
        }
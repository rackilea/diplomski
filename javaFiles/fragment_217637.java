return openFields.stream()
                 .collect(Collectors.toMap(Field::getName,
                                           field->field.getType().equals(Boolean.class)? 
                                                  ("true".equals(field.get(entity).toString())) ? 1 : 0
                                                  : field.get(entity)
                                           )
                         );
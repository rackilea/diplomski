Foo{test=true} 

 Exception in thread "main"
 com.fasterxml.jackson.databind.exc.MismatchedInputException: Cannot
 coerce Number (1) for type `boolean` (enable
 `MapperFeature.ALLOW_COERCION_OF_SCALARS` to allow)  at [Source:
 (String)"{"test": 1}"; line: 1, column: 10] (through reference chain:
 Main2$Foo["test"])
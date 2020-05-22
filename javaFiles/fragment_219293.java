final SqlInfo sqlInfoAnnotation = (SqlInfo) c.getAnnotation(SqlInfo.class);    
if (sqlInfoAnnotation == null) return;

final CodificationInfo codInfoAnnotation = sqlInfoAnnotation.codificationInfo();

final Class<?> codClass = codInfoAnnotation.codificationClass();
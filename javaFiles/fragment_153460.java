#macro(addFieldComparison $field)
  ## Check if the field is a String
  // CHECKED TYPE: ${field.accessor.class.name}
  #if (${field.accessor.class.name} == "java.lang.String")
    //is a String
    if(StringUtils.isNotEmpty($field.accessor) ? !${field.accessor}.equals(${classInstanceName}.$field.accessor) : StringUtils.isNotEmpty(${classInstanceName}.$field.accessor))return false;
  #else
    // Not a String
    if($field.accessor != null ? !${field.accessor}.equals(${classInstanceName}.$field.accessor) : ${classInstanceName}.$field.accessor != null)return false;
  #end
#end
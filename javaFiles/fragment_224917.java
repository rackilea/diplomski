StringBuilder sb=new StringBuilder();
for (final FieldError fieldError : result.getFieldErrors()) {
      sb.append(fieldError.getField())
           .append(" - ")
           .append(getErrorMessageFromProperties(fieldError.getCode()))
           .append("*");
 }
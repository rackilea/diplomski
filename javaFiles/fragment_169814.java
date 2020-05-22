#set( $objectProperties = $BeanUtils.describe($myParameter) )

INSERT INTO mytable (
  #foreach($property in $objectProperties)
    ${property.key}
  #end
)
VALUES (
  #foreach($property in $objectProperties)
    @{property.value}
  #end
)
|===
|Path|Type|Description|Optional

{{#fields}}
 |{{#tableCellContent}}
ifeval::["{{optional}}"=="true"]
   `{{path}}`
endif::[]
ifeval::["{{optional}}"=="false"]
   *`{{path}}`*
endif::[]
  {{/tableCellContent}}
  |{{#tableCellContent}}`{{type}}`{{/tableCellContent}}
  |{{#tableCellContent}}{{description}}{{/tableCellContent}}
  |{{#tableCellContent}}{{optional}}{{/tableCellContent}}

{{/fields}}
|===
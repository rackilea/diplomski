subquery_from_clause ::= FROM subselect_identification_variable_declaration ...
subselect_identification_variable_declaration ::=
  identification_variable_declaration |
  derived_path_expression [AS] identification_variable {join}* |
  derived_collection_member_declaration
derived_path_expression ::=
  superquery_identification_variable.{single_valued_object_field.}*collection_valued_field |
  superquery_identification_variable.{single_valued_object_field.}*single_valued_object_field
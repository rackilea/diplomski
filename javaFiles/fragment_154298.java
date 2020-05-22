UPDATE COLUMN FAMILY your_CF_name with column_type = 'Standard'
      and comparator = 'UTF8Type'
      and default_validation_class = 'UTF8Type'
      and key_validation_class = 'UTF8Type'
      and column_metadata = [
        {column_name : 'your_all_existing_columns',
        validation_class : your_all_existing_validation_class,
        index_name : 'user_defined_name',
        index_type : 0},
           .
           .
           .
    {column_name : 'your_new_additional_column',
        validation_class : your_validation_class,
        index_name : 'user_defined_name',
        index_type : 0}];
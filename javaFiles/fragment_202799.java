foreach ($tables as $table) {
    $columns = $DB->get_columns();
    foreach ($columns as $column) {
        ...
    }
}
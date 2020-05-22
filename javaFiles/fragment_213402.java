Map<String, List> resultSets = [:]

...

sqlStatements.each { queryAlias, query ->

    def columns=[]
    sql.eachRow(query) { row ->
        if (columns.isEmpty()) {
            int colCount = row.columnCount
            columns = (1..colCount).collect { row.getColumnName it }
        }

        resultSets[queryAlias] = columns.collect { column -> 
            row.getColumn(column) 
        }
    }
}
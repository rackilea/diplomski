Set<GroovyRowResult> rowResults = [] as Set
Sql sql = // instantiate using a Connection, DataSource, or whatever
List<String> spCallStrings = [] // add the SQL strings that calls each proc to this List

spCallStrings.each { spCallString ->

    rowResults.addAll(sql.rows(spCallString))
}
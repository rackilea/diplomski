PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
PREFIX owl: <http://www.w3.org/2002/07/owl#>
PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
SELECT ?datatype ?restr_type ?restr_value {
    ?prop rdfs:range ?range.
    ?range owl:onDatatype ?datatype;
        owl:withRestrictions ?restr_list.
    ?restr_list rdf:rest*/rdf:first ?restr.
    ?restr ?restr_type ?restr_value
}
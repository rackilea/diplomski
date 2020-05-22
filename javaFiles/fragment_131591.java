SELECT ?label ?thumbnail
WHERE {
    <http://dbpedia.org/resource/Harry_Potter> dbo:abstract ?label . 
    FILTER (lang(?label) = 'en')
    <http://dbpedia.org/resource/Harry_Potter> dbo:thumbnail ?thumbnail .
}
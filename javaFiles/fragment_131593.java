SELECT ?label ?thumbnail
WHERE {
    res:Harry_Potter
        dbo:abstract ?label ; 
        dbo:thumbnail ?thumbnail .
    FILTER (lang(?label) = 'en')
}
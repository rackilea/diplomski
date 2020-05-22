MATCH (N1:Vertex {id: 1})
OPTIONAL MATCH (N1)-[R:Padre]->(N2:Vertex {id:3})
WITH N1, FILTER(k in keys(N1) WHERE k<>'id' AND k<>'idAlbero') as kN1,
     N2, FILTER(k in keys(N2) WHERE k<>'id' AND k<>'idAlbero') as kN2
WITH N1, kN1, REDUCE(sum1=0.0, k in kN1 | sum1 + toFloat(N1[k])) as sum1,
     N2, kN2, REDUCE(sum2=0.0, k in kN2 | sum2 + toFloat(N2[k])) as sum2
WITH N1, kN1, CASE WHEN sum1 IS NULL THEN 0 ELSE sum1 END as sum1,
     N2, kN2, CASE WHEN sum2 IS NULL THEN 0 ELSE sum2 END as sum2,
     sum1 + toFloat(sum2) as total
RETURN N1, kN1, sum1,
       N2, kN2, sum2,
       sum1 + sum2 as total
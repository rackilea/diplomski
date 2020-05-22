CREATE 
    (a {name:'A'}),
    (b {name:'B'}),
    (c {name:'C'}),
    (d {name:'D'}),
    (e {name:'E'}),
    (f {name:'F'}),
    a-[:OWES {amount:100}]->b,
    b-[:OWES {amount:200}]->c,
    c-[:OWES {amount:300}]->a,
    e-[:OWES {amount:400}]->f,
    f-[:OWES {amount:500}]->e



start nn=node(*)
MATCH nn-[nr:OWES]->() 
WITH nn, nr ORDER BY nn.name, nr.amount
WITH COLLECT([nn, nr.amount]) as sortedPairs
START n=node(*)
match p=n-[r:OWES*1..200]->n
WITH sortedPairs, 
    extract(s in r: [STARTNODE(s), s.amount]) as pairs
WITH  
    filter(sp in sortedPairs: ANY(f in pairs WHERE HEAD(f) = HEAD(sp) AND LAST(f) = LAST(sp))) as finalPairs     
return distinct
    extract(s in finalPairs : HEAD(s)),
    extract(s in finalPairs : LAST(s)),
    length(finalPairs)
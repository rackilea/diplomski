+----------------------------------------------------------------------------------------------------------------------+
| extract(s in finalPairs : HEAD(s))                         | extract(s in finalPairs : LAST(s)) | length(finalPairs) |
+----------------------------------------------------------------------------------------------------------------------+
| [Node[39]{name:"E"},Node[38]{name:"F"}]                    | [400,500]                          | 2                  |
| [Node[43]{name:"A"},Node[42]{name:"B"},Node[41]{name:"C"}] | [100,200,300]                      | 3                  |
+----------------------------------------------------------------------------------------------------------------------+
2 rows
13 ms

Execution Plan

Distinct(_rows=2, _db_hits=0)
ColumnFilter(symKeys=["sortedPairs", "pairs", "finalPairs"], returnItemNames=["finalPairs"], _rows=5, _db_hits=0)
  Extract(symKeys=["sortedPairs", "pairs"], exprKeys=["finalPairs"], _rows=5, _db_hits=0)
    ColumnFilter(symKeys=["n", "sortedPairs", "  UNNAMED155", "pairs", "p", "r"], returnItemNames=["sortedPairs", "pairs"], _rows=5, _db_hits=0)
      Extract(symKeys=["n", "sortedPairs", "  UNNAMED155", "p", "r"], exprKeys=["pairs"], _rows=5, _db_hits=13)
        ExtractPath(name="p", patterns=["  UNNAMED155=n-[:OWES*1..200]->n"], _rows=5, _db_hits=0)
          PatternMatch(g="(n)-['  UNNAMED155']-(n)", _rows=5, _db_hits=0)
            AllNodes(identifier="n", _rows=6, _db_hits=6)
              ColumnFilter(symKeys=["  INTERNAL_AGGREGATEfbdcf75a-046d-4501-9696-1e2c80469b29"], returnItemNames=["sortedPairs"], _rows=1, _db_hits=0)
                EagerAggregation(keys=[], aggregates=["(  INTERNAL_AGGREGATEfbdcf75a-046d-4501-9696-1e2c80469b29,Collect)"], _rows=1, _db_hits=5)
                  ColumnFilter(symKeys=["nr", "  UNNAMEDS-2101388511", "  UNNAMEDS2003458696", "nn", "  UNNAMED39"], returnItemNames=["nn", "nr"], _rows=5, _db_hits=0)
                    Sort(descr=["SortItem(Cached(  UNNAMEDS2003458696 of type Any),true)", "SortItem(Cached(  UNNAMEDS-2101388511 of type Any),true)"], _rows=5, _db_hits=0)
                      Extract(symKeys=["nn", "  UNNAMED39", "nr"], exprKeys=["  UNNAMEDS2003458696", "  UNNAMEDS-2101388511"], _rows=5, _db_hits=10)
                        PatternMatch(g="(nn)-['nr']-(  UNNAMED39)", _rows=5, _db_hits=0)
                          AllNodes(identifier="nn", _rows=6, _db_hits=6)
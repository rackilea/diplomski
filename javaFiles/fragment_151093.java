FOR v, e
  IN ANY SHORTEST_PATH
  'germanCity/Cologne' TO 'germanCity/Hamburg'
  GRAPH 'routeplanner'
  OPTIONS {weightAttribute:'distance'}
  RETURN [v._key, e._key]
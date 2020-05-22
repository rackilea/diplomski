SELECT ?resource1 ?p1 ?intermediary ?p2 ?resource2
WHERE
{
  VALUES ?resource1 { :Paris :France :Europe }
  VALUES ?resource2 { :Paris :France :Europe }
  FILTER(?resource1 != ?resource2)

  {
    ?resource1 ?p1 ?resource2
  }
  UNION
  {
    ?resource1 ?p1 ?intermediary.
    ?intermediary ?p2 ?resource2.
  }
}
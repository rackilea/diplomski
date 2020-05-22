for (Concept x : qb.<MatchQuery>parse("match $x isa person;").get("x")) {
    System.out.println(x);
}

if (qb.<AskQuery>parse("match has name 'Bob' isa person; ask;").execute()) 
{
  System.out.println("There is someone called Bob!");
}

qb.parse("insert isa person, has firstname 'Alice';").execute();

qb.parse("match $x isa person; delete $x;").execute();
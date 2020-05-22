case class Person(name: String, age: Int, gender: String)

def bucketsByPredicate(people: Seq[Person], predicates: Seq[Person => Boolean]) = {
  people.foldLeft(predicates.map(predicate =>
    (predicate, List.empty[Person])
  )) { case (predicates, person) =>
      predicates.map { case (predicate, members) =>
        (predicate, if(predicate(person)) person :: members else members)
      }
  }.map(_._2)
}
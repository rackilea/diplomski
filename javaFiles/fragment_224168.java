private Long countPeople ( List < Person > people , Person.Gender gender , Person.Maturity maturity )
{
    Objects.requireNonNull ( people );
    Objects.requireNonNull ( gender );
    Objects.requireNonNull ( maturity );

    Predicate < Person > predicate = ( Person person ) -> ( person.getGender ().equals ( gender ) && person.getMaturity ().equals ( maturity ) );
    Long count = people.stream ().filter ( predicate ).count ();
    return count;
}
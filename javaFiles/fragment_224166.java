private Integer countPeople ( List < Person > people , Person.Gender gender , Person.Maturity maturity )
{
    Objects.requireNonNull ( people );
    Objects.requireNonNull ( gender );
    Objects.requireNonNull ( maturity );

    Integer count = 0;
    for ( Person person : people )
    {
        if ( ( person.getGender ().equals( gender ) ) && ( person.getMaturity ().equals( maturity ) ) )
        {
            count = ( count + 1 );
        }
    }
    return count;
}
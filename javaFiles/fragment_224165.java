package work.basil.example;

import java.util.Objects;
import java.util.UUID;

public class Person
{
    public enum Gender
    {
        FEMALE, MALE
    }

    public enum Maturity
    {
        ADULT, CHILD
    }

    // Members
    private UUID id;
    private Gender gender;
    private Maturity maturity;

    // Constructor
    public Person ( UUID id , Gender gender , Maturity maturity )
    {
        Objects.requireNonNull ( id );
        Objects.requireNonNull ( gender );
        Objects.requireNonNull ( maturity );

        this.id = id;
        this.gender = gender;
        this.maturity = maturity;
    }

    // Accessors

    public UUID getId ( )
    {
        return id;
    }

    public Gender getGender ( )
    {
        return gender;
    }

    public Maturity getMaturity ( )
    {
        return maturity;
    }

    // Object overrides

    @Override
    public String toString ( )
    {
        return "Person{" +
                "id=" + id +
                ", gender=" + gender +
                ", maturity=" + maturity +
                '}';
    }

    @Override
    public boolean equals ( Object o )
    {
        if ( this == o ) return true;
        if ( o == null || getClass () != o.getClass () ) return false;
        Person person = ( Person ) o;
        return id.equals ( person.id );
    }

    @Override
    public int hashCode ( )
    {
        return Objects.hash ( this.id );
    }
}
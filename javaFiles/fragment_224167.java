List < Person > people = List.of (
        new Person ( UUID.randomUUID () , Person.Gender.FEMALE , Person.Maturity.CHILD ) ,
        new Person ( UUID.randomUUID () , Person.Gender.FEMALE , Person.Maturity.ADULT ) ,
        new Person ( UUID.randomUUID () , Person.Gender.MALE , Person.Maturity.ADULT ) ,
        new Person ( UUID.randomUUID () , Person.Gender.FEMALE , Person.Maturity.CHILD ) ,
        new Person ( UUID.randomUUID () , Person.Gender.MALE , Person.Maturity.ADULT ) ,
        new Person ( UUID.randomUUID () , Person.Gender.MALE , Person.Maturity.CHILD ) ,
        new Person ( UUID.randomUUID () , Person.Gender.FEMALE , Person.Maturity.ADULT )
);

Integer women = this.countPeople ( people , Person.Gender.FEMALE , Person.Maturity.ADULT );
Integer boys = this.countPeople ( people , Person.Gender.MALE , Person.Maturity.CHILD );
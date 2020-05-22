enum Demo{ A, B};

@Entity
class MyEntity {
   @Enumerated(EnumType.ORDINAL)
   private Demo demo;
}
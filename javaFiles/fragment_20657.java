public class SomethingBuilder {
     private String someString;
     private Integer someInt;

     public SomethingBuilder() {
         someString = "Some default value";
         someInt = 42;
     }

     public SomethingBuilder withSomeString(final String someString) {
         this.someString = someString;
         return this;
     }

     public SomethingBuilder withSomeInt(final Integer someInt) {
         this.someInt = someInt;
         return this;
     }

     public Something build() {
         final Something something = new Something(someString, someInt);
         return something;
     }
 }
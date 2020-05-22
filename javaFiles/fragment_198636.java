@Test     
public void testOtherNumber() {        
     String result = FizzBuzz.translateNumber(23);
     assertEquals("23", result);
 } 

@Test     
public void testMultipleOfThree() {        
     String result = FizzBuzz.translateNumber(3);
     assertEquals("Fizz", result);
 } 

@Test     
public void testMultipleOfFive() {        
     String result = FizzBuzz.translateNumber(25);
     assertEquals("Buzz", result);
 } 

@Test     
public void testMultipleOfFifteen() {        
     String result = FizzBuzz.translateNumber(45);
     assertEquals("FizzBuzz", result);
 }
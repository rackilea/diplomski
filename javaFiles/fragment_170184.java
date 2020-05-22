import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)

public class ClassATest {

@InjectMocks
ClassA classsA;
@Mock
ClassB classB;
@Test
public void testClassAMethod() {
    //Assuming ClassA has one method which takes String array,
    String[] inputStrings = {"A", "B", "C"}; 
    //when you call classAMethod, it intern calls getClassMethod(String input)
    classA.classAMethod(inputStrings); 
    //times(0) tells you method getClassBmethod(anyString()) been called zero times, in my example inputStrings length is three,
    //it will be called thrice
   //Mockito.verify(classB, times(0)).getClassBMethod(anyString());
    Mockito.verify(classB, times(3)).getClassBMethod(anyString());
    }
}
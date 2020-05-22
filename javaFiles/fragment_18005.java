import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.exceptions.verification.VerificationInOrderFailure;

public class MyTest {

    public interface ToBeTested{
        public void crucialMethod();
        public void methodX();
        public void methodY();
    }

    @Test
    public void testXThenY(){
        // Given
        ToBeTested toBeTested = mock(ToBeTested.class);

        // When
        toBeTested.crucialMethod();
        toBeTested.methodX();
        toBeTested.methodY();

        // Then

        InOrder inOrderX = inOrder(toBeTested);
        inOrderX.verify(toBeTested).crucialMethod();
        inOrderX.verify(toBeTested).methodX();

        InOrder inOrderY = inOrder(toBeTested);
        inOrderY.verify(toBeTested).crucialMethod();
        inOrderY.verify(toBeTested).methodY();
    }

    @Test(expected=VerificationInOrderFailure.class)
    public void crucialTooLateForX(){
        // Given
        ToBeTested toBeTested = mock(ToBeTested.class);

        // When

        toBeTested.methodX();
        toBeTested.crucialMethod();
        toBeTested.methodY();

        // Then

        InOrder inOrderX = inOrder(toBeTested);
        inOrderX.verify(toBeTested).crucialMethod();
        inOrderX.verify(toBeTested).methodX();

        InOrder inOrderY = inOrder(toBeTested);
        inOrderY.verify(toBeTested).crucialMethod();
        inOrderY.verify(toBeTested).methodY();
    }

    @Test(expected=VerificationInOrderFailure.class)
    public void crucialTooLateForY(){
        // Given
        ToBeTested toBeTested = mock(ToBeTested.class);

        // When

        toBeTested.methodY();
        toBeTested.crucialMethod();
        toBeTested.methodX();

        // Then

        InOrder inOrderX = inOrder(toBeTested);
        inOrderX.verify(toBeTested).crucialMethod();
        inOrderX.verify(toBeTested).methodX();

        InOrder inOrderY = inOrder(toBeTested);
        inOrderY.verify(toBeTested).crucialMethod();
        inOrderY.verify(toBeTested).methodY();
    }
}
import static org.hamcrest.core.IsSame.sameInstance;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;

import java.io.InputStream;

import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class FooKeyRetrieverTest {

    @Test
    public void testGetFooKey() throws Exception {
        // Arrange
        final FooKeyRetriever sut = spy(new FooKeyRetriever());
        FooKey mockedKey = mock(FooKey.class);

        doReturn(mockedKey)
            .when(sut).getKeyFromStream(any(InputStream.class), anyString());
        doAnswer(new Answer<FooKey>() {

            public FooKey answer(InvocationOnMock invocation) throws Throwable {
                return sut.getKeyFromStream(null, "");
            }
        }).when(sut).getKey(anyString());

        // Act
        FooKey ret = sut.getKey("test");

        // Assert
        assertThat(ret, sameInstance(mockedKey));
    }
}
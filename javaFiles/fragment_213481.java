import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(FooController.class)
public class FooControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private FooService fooServiceMock;

    @Test
    public void testExample() throws Exception {
         Foo mockedFoo = new Foo("one", "two");

         Mockito.when(fooServiceMock.get(1))
                .thenReturn(mockedFoo);

         mvc.perform(get("foos/1")
            .accept(MediaType.TEXT_PLAIN))
            .andExpect(status().isOk())
            .andExpect(content().string("one two"));
    }

}
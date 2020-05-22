import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@RunWith(SpringRunner.class)
public class TestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private GenericConversionService conversionService;

    @Before
    public void setup() {
        conversionService.addConverter(new BarToFooConverter());
    }

    @Test
    public void test() throws Exception {
        mockMvc.perform(
                put("/test")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"bar\":\"test\"}"))
                .andExpect(status().isOk());
    }
}
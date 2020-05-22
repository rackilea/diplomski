import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers=HomeController.class)
public class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void testSignOut() throws Exception {

        mockMvc.perform(post("/signout"))
            .andDo(print())
            .andExpect(new ResultMatcher() {                
                @Override
                public void match(MvcResult result) throws Exception {              
                    Assert.assertEquals("http://localhost:3000",result.getResponse().getRedirectedUrl());
                }
            });

    }

}
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.an.csv.CSVBatchApplication;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CSVBatchApplication.class)
@AutoConfigureMockMvc
public class ControllerIntegrationTest {

  @Autowired private MockMvc mockMvc;

  @Test
  public void testController() throws Exception {
    mockMvc
        .perform(get("/myclass"))
        .andExpect(status().isOk());
  }
}
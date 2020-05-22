import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class Controller {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/api/test")
    List<Map<String, Object>> getData() {
        return jdbcTemplate.queryForList("Select * FROM public.persons p JOIN public.companies c" +
                " ON p.company_id = c.id");
    }
}
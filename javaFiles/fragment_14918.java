package org.test;

import static org.junit.Assert.assertEquals;
import java.util.Map;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class EnvTest {

    @Resource
    private Map<String, String> map;

    @Test
    public void testMap() throws Exception {
        assertEquals("Me", map.get("mykey"));
    }

}
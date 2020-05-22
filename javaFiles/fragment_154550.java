package com.rationaleemotions.stackoverflow.qn45716815;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

@TestPropertySource("classpath:application.properties")
@SpringBootTest
public class FooTest extends AbstractTestNGSpringContextTests{
    @Autowired
    private Foo foo;

    @Test
    public void sanityCheck() {
        Assert.assertNotNull(foo);
    }

    @Test
    public void testProperty() {
        Assert.assertEquals(foo.ExposeProp(), "checkcheck");
    }
}
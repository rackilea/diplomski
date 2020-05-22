package com.test.dozer;

import java.util.Arrays;

import junit.framework.Assert;

import org.dozer.DozerBeanMapper;
import org.junit.Before;
import org.junit.Test;

public class DozerTest {

    private DozerBeanMapper mapper;

    @Before
    public void setUp() {
        mapper = new DozerBeanMapper(Arrays.asList("dozerMappingFile.xml"));
    }

    /**
     * Verifies that class1's id is mapped into class2's id when not null.
     */
    @Test
    public void testMappingWhenIdNotNull() {
        Class1 class1 = new Class1();
        class1.setId(1);
        Class2 class2 = new Class2();
        class2.setId(2);

        mapper.map(class1, class2);

        Assert.assertEquals(1, class2.getId());
    }

    /**
     * Verifies that class2's id is not set to null when class1's id is null.
     */
    @Test
    public void testMappingWhenIdIsNull() {
        Class1 class1 = new Class1();
        Class2 class2 = new Class2();
        class2.setId(2);

        mapper.map(class1, class2);

        Assert.assertEquals(2, class2.getId());
    }

}
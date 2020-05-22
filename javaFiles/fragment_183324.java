package com.example;

import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Question28819604 {

    @Test
    public void test() {
        Assert.assertEquals(37,convertSize("X(37)"));
        Assert.assertEquals(4,convertSize("9(03)"));
        Assert.assertEquals(15,convertSize("X(15)"));
        Assert.assertEquals(8,convertSize("9(07)"));
        Assert.assertEquals(1,convertSize("X"));
        Assert.assertEquals(1,convertSize("X(1)"));
        Assert.assertEquals(253,convertSize("X(253)"));
        Assert.assertEquals(0,convertSize("non-match"));
        Assert.assertEquals(0,convertSize(null));
        Assert.assertEquals(0,convertSize("X(broken)"));
        Assert.assertEquals(0,convertSize("X(broken"));
    }

    private Pattern xPattern = Pattern.compile("X\\((\\d+)\\)");
    private Pattern ninePattern = Pattern.compile("9\\((\\d+)\\)");

    private int convertSize(String pic) {
        if (pic == null) {
            return 0;
        }

        Matcher xPatternMatcher = xPattern.matcher(pic);
        Matcher ninePatternMatcher = ninePattern.matcher(pic);

        if ("X".equals(pic)) {
            return 1;
        } else if (xPatternMatcher.matches()) {
            return Integer.parseInt(xPatternMatcher.group(1));
        } else if (ninePatternMatcher.matches()) {
            return Integer.parseInt(ninePatternMatcher.group(1)) + 1;
        } else {
            return 0;
        }
    }
}
package com.stackoverflow.question.jersey.with.spring;

import javax.inject.Inject;
import org.springframework.stereotype.Component;

@Component
public class OtherCategoryManager implements CategoryManager
{
    @Inject
    private CategoryDAO categoryDAO;

    @Override
    public String saySomething()
    {
        return "Using OtherCategoryManager!";
    }
}
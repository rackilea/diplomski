package com.stackoverflow.question.jersey.with.spring;

import javax.inject.Inject;
import org.springframework.stereotype.Component;

@Component
public class CategoryManagerFactory
{
    @Inject
    private MyCategoryManager myCategoryManager;

    @Inject
    private OtherCategoryManager otherCategoryManager;

    public CategoryManager obtainCategoryManager(CategoryManagerTypes type)
    {
        switch (type) {
            case MY:
                return myCategoryManager;
            case OTHER:
                return otherCategoryManager;
            default:
                throw new IllegalArgumentException(String.format("Category %s not supported", type));
        }
    }

    public enum CategoryManagerTypes
    {
        MY, OTHER;
    }
}
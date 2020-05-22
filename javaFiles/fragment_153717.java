public MyWebApplicationInitializer implements WebApplicationInitializer 
{
    @ Override
    protected Filter[] getServletFilters() 
    {
        return new Filter[] {new MyFilter()}; // MyFilter refers to the filter needed class
    }
}
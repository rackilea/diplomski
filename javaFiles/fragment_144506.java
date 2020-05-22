class FilterChain<IFilter> {
    ...
    public void filter() 
    {
         for(IFilter filter: filterChain)
         {
             filter.doFilter();
         }
    }
}
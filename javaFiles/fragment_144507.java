class FilterChain<T> {
    ...
    public void filter() 
    {
         for(T filter: filterChain)
         {
             filter.doFilter();
         }
    }
}
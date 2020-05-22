public SimpleFilterProvider() {
    _filtersById = new HashMap<String,BeanPropertyFilter>();
}

/**
 * @param mapping Mapping from id to filter; used as is, no copy is made.
 */
public SimpleFilterProvider(Map<String,BeanPropertyFilter> mapping) {
    _filtersById = new HashMap<String,BeanPropertyFilter>();
}
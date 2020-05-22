@Override
default Page<Employee> findAll(Pageable p) {
    if (p.getSort() == null) {      
        // The default sort order
        return findBy(new PageRequest(p.getPageNumber(), p.getPageSize(), Sort.Direction.DESC, "myField"));
    }
    return findBy(pageable);
}
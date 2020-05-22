@Override
default Page<Employee> findAll(Pageable pageable) {
    return findBy(pageable);
}

@RestResource(exported = false)
Page<Employee> findBy(Pageable pageable);
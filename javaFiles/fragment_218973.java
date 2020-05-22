@GetMapping("/query-dsl")
public Page<ResponseDto> getAllByQueryDsl(
        @QuerydslPredicate(root = MyEntity.class, bindings = MyEntityRepo.class) Predicate predicate,
        Pageable pageable
) {
    return service.getAllByQueryDsl(predicate, pageable);
}
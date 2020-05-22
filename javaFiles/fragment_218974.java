@GetMapping("/specification")
public Page<ResponseDto> getAllBySpecification(
        @And({
                @Spec(path = "name", spec = LikeIgnoreCase.class),
                @Spec(path = "createdAt", params = "from", spec = GreaterThanOrEqual.class),
                @Spec(path = "createdAt", params = "to", spec = LessThanOrEqual.class)
        }) Specification<MyEntity> specification,
        Pageable pageable
) {
    return service.getAllBySpecification(specification, pageable);
}
@GetMapping("/q")
public List<ResponseDto> getAllByQuery(
    @RequestParam(value = "name", required = false) String name,
    @RequestParam(value = "from", required = false) @DateTimeFormat(iso = ISO.DATE) LocalDate from,
    @RequestParam(value = "to", required = false) @DateTimeFormat(iso = ISO.DATE) LocalDate to,
    Pageable pageable
) {
    return service.getByQuery(name, from, to, pageable);
}
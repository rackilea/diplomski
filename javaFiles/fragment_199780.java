@GetMapping(value = "/restaurant_representation", produces = MediaType.APPLICATION_JSON_VALUE)
    public RestaurantRepresentation restaurantRepresent(
        @RequestParam(value = "date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
        @RequestParam(value = "id") Integer id) {
            return date == null ?
                restaurantRepresentationCompiler.compileRestaurantRepresentation(id, LocalDate.now()) :
                restaurantRepresentationCompiler.compileRestaurantRepresentation(id, date);
}
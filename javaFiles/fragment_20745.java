@GetMapping("/movie/{id}")
 public String moviesDetails(@PathVariable
                                String id, ModelMap map) {
        System.out.println(id);
        map.addAttribute("movieId", id);
        return "moviesDetails";
    }
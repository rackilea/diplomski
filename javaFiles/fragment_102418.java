@GetMapping("/api/@{term:.+}")
public void index(@PathVariable String term) {
    // term is whatever after the "@"
    // you can parse the term to what you want
    // {term:.+} is a regex mapping for including the last dot
}
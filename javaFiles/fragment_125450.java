@GetMapping("/bugs")
public ReponseEntity getAll() { 
   return ResponseEntity.ok(new HashMap<String, List<InsectObject>>() {{
            put("bug", repository.findAll());
        }});
}
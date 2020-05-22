@RequestMapping("/resa")
public String reservation(Model model,
       @RequestParam("date") Optional<LocalDateTime>> optionalDate){

    LocalDateTime date = optionalDate.orElseGet(()-> LocalDateTime.now());
}
@GetMapping("modifica")
public ModelAndView modificaVeicolo(@RequestParam("targa") String targa, Model model) {

    Set<Veicolo> veicoli = (Set<Veicolo>) model.asMap().get("veicoli");
    Veicolo veicoloMod = null;
    for (Veicolo v : veicoli) {
        if (v.getTarga().equalsIgnoreCase(targa)) {
            veicoloMod = v;
            model.addAttribute(veicoloMod);
            break;
        }
    }
    return new ModelAndView("veicolo/modifica_veicolo", "modelVeicolo", veicoloMod);
}
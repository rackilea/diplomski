@PostMapping("update")
public ModelAndView updateVeicolo(@ModelAttribute("modelVeicolo") Veicolo veicolo, BindingResult bindingResult,
                                  Model model) {

//        Veicolo veicoloToUpdate = (Veicolo)model.asMap().get("veicoli");


    veicoloValidator.validate(veicolo, bindingResult);

    if (bindingResult.hasErrors()) {
        return new ModelAndView("veicolo/modifica_veicolo");
    } else {
        Set<Veicolo> veicoli = (Set<Veicolo>) model.asMap().get("veicoli");

        if (veicoli.contains(veicolo)) {
            veicoli.remove(veicolo);
            veicoli.add(veicolo);
        }

    }
    return new ModelAndView("veicolo/lista_veicoli");
}
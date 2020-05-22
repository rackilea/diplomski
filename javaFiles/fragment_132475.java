@RequestMapping(value="/owners/{ownerId}/pets/{petId}", method=RequestMethod.GET)
public String findPet(@PathVariable String ownerId, @PathVariable String petId, Model model) {
  Owner owner = ownerService.findOwner(ownerId);  
  Pet pet = owner.getPet(petId);  
  model.addAttribute("pet", pet);  
  return "displayPet"; 
}
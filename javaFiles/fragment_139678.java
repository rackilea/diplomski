@RequestMapping("/first")
    String first(ModelMap model, final RedirectAttributes redirectAttributes) {
        model.put("list", new ArrayList<String>());
        redirectAttributes.addFlashAttribute("list", new ArrayList<String>());
        return "redirect:/second";
    }

    @RequestMapping("/second")
    String second(ModelMap model, final RedirectAttributes redirectAttributes) {
        List list = (List) model.get("list");
        list.add("A");
        redirectAttributes.addFlashAttribute("list", list);
        return "redirect:/third";
    }

    @RequestMapping("/third")
    String third(ModelMap model, final RedirectAttributes redirectAttributes) {
        List list = (List) model.get("list");
        list.add("B");
        redirectAttributes.addFlashAttribute("list", list);
        return "end";
    }
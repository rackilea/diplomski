@RequestMapping(value="/new_expense", method = RequestMethod.GET)
    public String diplayAddExpenseForm( Model model) {
        System.out.println("inside  display");
        model.addAttribute("expense", new Expense());
        return "addexpenseform";

    }

    @RequestMapping(value= "/save", method=  RequestMethod.POST)
    public String processAddExpenseForm(@Valid Expense expense, BindingResult br,
                                        Model model, RedirectAttributes ra) {
        System.out.println("inside processform");
        if(br.hasErrors()) {
            System.out.println("inside has er");    
            return"addexpenseform";

        }

        model.addAttribute("expense", expense);

        expService.saveExpense(expense);

        ra.addFlashAttribute("expense", expense);

        return "redirect:/customers";
    }

    @RequestMapping(value= "/cancel",method= {RequestMethod.GET, RequestMethod.POST})
    public String cancelAddExpenseForm() {

        return "redirect:/customers";
    }
@ModalAttribute("results")
public List<Loans> populateLoans() {
    return new ArrayList<Loans>();
}

@RequestMapping("/main")
public String getMain(Model model,HttpSession session,@ModalAttribute("results") List<Loans> loansList){
    if (CollectionUtils.isNotEmpty(loanList)) {
        // do something if the loan list is not empty. 
    }
}
@GetMapping("app/")
    public ModelAndView app() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("app/index");

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepo.findByUsername(userDetails.getUsername()).orElse(null);

        List<Wallet> wallets = user.getWallets(); // no error anymore
        mv.addObject("wallets", wallets);

        return mv;
    }
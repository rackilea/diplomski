@RequestMapping(value="/", method=RequestMethod.POST)
   public ModelAndView PostBitcoinWallet(@RequestParam String amount,@RequestParam String address) {

      ModelMap modelMap = new ModelMap();
        modelMap.put("amount", amount);
        modelMap.put("address", address);

      return new ModelAndView("sendMoney",modelMap);
   }
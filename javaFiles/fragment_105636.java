@RequestMapping(value = "/money", method = RequestMethod.GET)
public String money(HttpServletRequest request, @ModelAttribute Bean bean){
  BigDecimal moneyIn = new BigDecimal(0);
  String input = bean.get***();//pass in onlcick from jsp. 
  if(input.equals("addOne")){
       moneyIn.add(new BigDecimal(1.00));
  }

  if(input.equals("")){
      moneyIn.add(new BigDecimal(.25));
  }
}
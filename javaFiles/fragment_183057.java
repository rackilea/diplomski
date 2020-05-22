if(b_num){
    model.addAttribute("billingNumber",new String(ch, start, length));   
    b_num = false;
}
if(b_krb){
    model.addAttribute("kodeRefBank",new String(ch, start, length));
    b_krb = false;
}
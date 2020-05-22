@RequestMapping(value="/DomainEkle",method=RequestMethod.POST)
    public ModelAndView domain_eklendi_fonksiyon(@ModelAttribute("Domain")Domain domain, ModelMap model)
    {
        this.domainJDBCTemplate.listDomains();

        model.addAttribute("domain", domain.getDomain_adi());
        model.addAttribute("sunucu", domain.getSunucu_no());
        model.addAttribute("tarih", domain.getTarih());
        System.out.println(domain.getTarih()+"-"+domain.getDomain_adi());
        String message="Domain Kaydi Yapilmistir!";
        ModelAndView dm_eklendi=new ModelAndView("DomainEkle","message",message);


        return dm_eklendi;


    }
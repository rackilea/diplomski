AtomicInteger seq = new AtomicInteger();//Global variable

@RequestMapping(value = "/agn/AP1W01A_004", method=RequestMethod.GET)
    public ModelAndView welcomeGrid(@RequestParam("payType")String payType){
        seq.set(gnRecService.findTheLastPK(payType));
        ModelAndView view = new ModelAndView(".agn.AP1W01A_004");
        return view;
    }

    public ModelAndView showPk() {
        final int localSeq = seq.addAndGet(2); 
        ModelAndView view = new ModelAndView(".agn.AP1W01A_004");
        view.addObject("seq",localSeq)
        return view;
    }
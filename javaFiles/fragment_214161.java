VTDGen vg =  new VTDGen();
    if (vg.parseFile("c://xml//alex.txt", true)){
        VTDNav vn = vg.getNav();
        AutoPilot ap = new AutoPilot(vn);
        ap.selectXPath("//L/D");
        int i=-1;
        while((i=ap.evalXPath())!=-1){
            long l = vn.getContentFragment();
            System.out.println(" -==> "+ vn.toString((int )l, (int)(l>>32)));
        }
    }
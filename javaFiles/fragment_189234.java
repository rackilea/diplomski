if(m1==null){
    m1 =  new Menu_Modifications_Single();
    JInternalFrame iFrame = 
            new JInternalFrame("Internal Frame", true, true, true, true);    
            /* give the same contents of m1 */
    iFrame.setContentPane(m1.getContentPane());    
            /* additional Integer argument, required by JDesktopPane
              (although not strictly required) */
    desktopPane.add(iFrame, new Integer(0));    
}
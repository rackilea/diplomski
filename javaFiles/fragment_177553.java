IWorkbenchPage page = ...;

    //adding a listener
IPartListener2 pl = new IPartListener2() {
        // ... Other methods
        public void partClosed(IWorkbenchPartReference partRef)
        {
            //if(partRef.getId().equals(youreditor.id){ /* do something*/ }
        }

};
page.addPartListener(pl);
Button b1 = new Button("b1");
b1.addClickHandler(new ClickHandler) {
    // call RPC and 
   // session = this.getThreadLocalRequest().getSession();
  // session.setAtribute("b", "1");
}


Button b2 = new Button("b2");
b1.addClickHandler(new ClickHandler) {
    // call RPC and 
   // session = this.getThreadLocalRequest().getSession();
  // session.invalidate(); // kill session
}
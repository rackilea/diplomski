new Link<MyObject>("myLink") {
     public void onClick()
     {
         MyObject obj = getModelObject();
         setResponsePage(new MyPage(obj));
     }
}
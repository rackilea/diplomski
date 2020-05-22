package com.ejb;

@Service
public class MyService {

   private MyEjbLocal ejb;

   public void setMyEjbLocal(MyEjbLocal ejb){
        this.ejb = ejb;
  }

  public MyEjbLocal getMyEjbLocal(){
       return ejb;
  }
}
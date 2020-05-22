try this in your code

public void setInfo(IndentityInfo info)
  {


   Hibernate.initialize(info);     
   this.info = info;

  }
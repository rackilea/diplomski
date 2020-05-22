private Date empdob;  

   public Date getEmpdobDate() {  
     return this.empdob;  
   }  

   public void setEmpdobDate(Date empdob) {  
     this.empdob = empdob;  
   }  

   public String getEmpdobString() {  
     return someDateFormatter.format(this.empdob);  
   }  

   public void setEmpdobString(String s) {  
     this.empdob = someDateFormatter.parse(s);  
   }
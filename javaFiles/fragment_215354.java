@Entity
public MyEntity {

   @Column(name="ACTUAL_VALUE")
   private String myProperty1;
   private String myProperty2;

   public void setMyPropert1(String str){
       myProperty1 = str;
       myProperty2 = str;
   }
   public void setMyPropert2(String str){
       myProperty1 = str;
       myProperty2 = str;
   }
   public void setMyPropert2(){
       myProperty2 = myProperty1;
   }
   @Transient
   public String getMyPropertyAliasOne(){
        return myProperty1;
   }

   public String getMyPropertyAliasTwo(){
        return myProperty2;
   }
}
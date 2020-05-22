for(int i = 0; i<count; i++){
     System.out.println("Insert activity code");
     String code = input.nextLine();
     Activity a = activities.get(code);

     if(a != null) {
         companyAcitivities.put(code, a.clone()); //the error refers to this line
     }
}
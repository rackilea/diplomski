Collections.sort(list, new Comparator<com.MyObject>() {

          public int compare(com.MyObject object1, com.MyObject object2) {

            if(myString.equalsIgnoreCase("name")){
            return object1.getName().compareTo(object2.getName());

          }else if(myString.equalsIgnoreCase("age")){
            return object1.getAge().compareTo(object2.getAge());

          }else{
            return object1.getOrder() - object2.getOrder();
          }
      }
  });
Product product = repository.getProduct(id)
   ProductBuilder.Builder builder = new ProductBuilder.Builder()

   if(product ==  null){
     builder.location("abc").quantity(5).price(10)
     if(parmas.getAvaiability() != null){
          builder.availability(parmas.getAvaiability())
     }

   } else {
      builder.withProduct(product)
             .availability(params.getAvailability())
   }
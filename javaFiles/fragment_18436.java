//Let me show a example update a object.
  Customer customerToUpdate = customerRepository.getOne(id);
  customerToUpdate.setName(customerDto.getName);
  customerRepository.save(customerToUpdate);
  //But your code directly updating a user account without find  the user  which is gonna changed.I could't examine full of codes but ı think problem occurs here.
      memberservice.updateMember(mb);
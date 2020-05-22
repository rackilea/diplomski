owner.set(new Phone(2222));
entityManager.merge(owner));
// update the owner phone
owner.set(new Phone(77777));
//the phone(2222) will be deleted
entityManager.merge(owner));
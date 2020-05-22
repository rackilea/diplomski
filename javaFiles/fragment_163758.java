Membership membership = new Membership();
membership.setPerson(person);
membership.setPersonGroup(personGroup);
personGroup.getMemberships().add(membership);

membershipSession.persist(membership);
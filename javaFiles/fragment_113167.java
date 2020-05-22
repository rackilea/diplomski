//some system that contains all our customers information
class PersonDao {
   findPersonBySSN( long ssn )
}

//some other system where we store pets
class PetDao {
   findPetsByAreaCode()
   findCatByFullName()
}

//some web portal your building has this service
class OurPortalPetLostAndFoundService {

   notifyOfLocalLostPets( Person p ) {
      Location l = ourPortalEntityManager.findSingle( PortalUser.class, p.getSSN() )
        .getOptions().getLocation();
      ... use other DAO's to get contact information and pets...
   }
}
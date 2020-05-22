db.XX.update(
    // Find the document where userEmail=some@some.com and find the element in the "reservations" array where idRest=24
    {
        "userEmail":"some@some.com", 
        "reservations.idRest":24
    }, 
    // Update the element matched by the find criteria with new values
    {
        $set:{
           "reservations.$.idRest":99, 
           "reservations.$.userPhone":"888888", 
           "reservations.$.date":"03-13-2015", 
           "reservations.$.hour":"17:30"
        }
    }
)
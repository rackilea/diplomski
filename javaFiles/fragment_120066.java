Below code fetches Only those instrcutors having IdProof present in
  DB . If No Instructor is having idProof present in db then written
  query will return empty List as there is inner join between
  Instructor and IdProof . 

  All Instructors not having any vehicle will also be fetched and their
  vehicle list  will be initialised as empty.

  All vehicle not having any document will also be fetched along with
  vehicles having atleast one document . Vehicles not having any
  document can be avoided in code while processing data . 

  But if inner join is created between Vehicle and document and if
  there is no  document present in db then it will make the complete
  result empty . As final inner join will be applied on join results
  evaluted till yet in db on first three tables Instructor , IdProof and 
  Vehcile.


    try {
       TypedQuery<Instructor> 
       typedQueryLeftJoinAndJoinFetchMixed = 
       em.createQuery(" select i from Instructor i "
               + " join fetch i.idProof id " 
               + " left join i.vehicles v " 
               + " left join v.documents vd ",
                    Instructor.class);
       typedQueryLeftJoinAndJoinFetchMixed.
                   setHint("javax.persistence.fetchgraph", instructorGraph);
       List<Instructor> 
           instructorsWithLeftJoinAndJoinFetchMixed = 
                               typedQueryLeftJoinAndJoinFetchMixed
                                        .getResultList();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        }
else{
                System.out.println("LELEH");

                CoreService data = (CoreService )result.get(0);

                data.setCATEGORY("SYSTEMID");

                data.setCOUNTER_SYSTEM(2);

                data.setCOUNTER_SERVICE(2);



                session.beginTransaction();
                session.update(data);
                session.getTransaction().commit();

            }
public CrbtSubMasterDemo{
         private Stirng mobile;
         private String password;

          public CrbtSubMasterDemo(){
            --------------
         }

        #####after setting the transation set whichever columns you are selecting should be given as name of property of your object
        String hql = "select c.mobile as mobile, c.password as password FROM CrbtSubMasterDemo c where rownum<20";
        Query query = session.createQuery(hql);
        List<CrbtSubMasterDemo> itr = query.setResultTransformer(Transformers.aliasToBean(CrbtSubMasterDemo.class) ).list();
        ##No need to commit the transaction.
    }
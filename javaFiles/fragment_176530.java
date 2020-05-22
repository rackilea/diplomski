public List<Companies> getFilteredData(int start,
            int length,
            String companyName,
            String state,
            Integer empId,
            String country,
            String website,
            Integer pTech,
            Integer sTech,
            Integer status){



      List<Criterion> criterionList=new ArrayList<Criterion>();

      if(null!=companyName && !companyName.isEmpty())
          criterionList.add(Restrictions.like("companyName",companyName));
     if(null!=state && !state.isEmpty())
         criterionList.add(Restrictions.like("state",state));
     if(null!=empId )
         criterionList.add(Restrictions.eq("employee.id",empId));
     if(null!=country && !country.isEmpty())
         criterionList.add(Restrictions.like("country",country));
     if(null!=website && !website.isEmpty())
         criterionList.add(Restrictions.like("website",website));
     if(null!=pTech )
         criterionList.add(Restrictions.eq("primTech.id",pTech));
     if(null!=sTech )
         criterionList.add(Restrictions.eq("secondTech.id",sTech));
     if(null!=status )
         criterionList.add(Restrictions.or(Restrictions.eq("statuss.id",status));

         Criteria cr=factory.getCurrentSession().createCriteria(Companies.class);
         cr.createAlias("primTech","primTech");
         cr.createAlias("secondTech","secondTech");
         cr.createAlias("statuss","statuss");
         cr.createAlias("employee","employee");

         if(null!=criterionList && !criterionList.isEmpty())
             for(Criterion criterion:criterionList)
                 if(null!=criterion)
                     cr.add(criterion);


         return cr.list();

  }
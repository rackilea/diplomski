//Hibernate Create a Session Factory    
 SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();         
for (int i = 0; i < Bloomberg.getTickerSymbol().size(); i++){

        //Hibernate to store Stock Tickers Data     
    tickerInfo.setTickerSymbol(Bloomberg.getTickerSymbol().get(i)); //Symbol
    tickerInfo.setTickerName(Bloomberg.getTickerName().get(i)); //Name
    tickerInfo.setTickerSector(Bloomberg.getTickerSector().get(i)); //Sector
    tickerInfo.setTickerIndustry(Bloomberg.getTickerIndustry().get(i)); //Industry
    tickerInfo.setTickerLastUpdate(Calendar.getInstance().getTime()); //Update Date

    org.hibernate.Session session = sessionFactory.openSession();
    List tickerInfos = session.createCriteria(TickerInfo.class).add(Restrictions.eq("tickerSymbol", Bloomberg.getTickerSymbol().get(i))).list();
   if(tickerInfos.size()<1){
         session.beginTransaction(); 
         session.saveOrUpdate(tickerInfo);
         session.getTransaction().commit();
   }
   session.close();
 }
Session session = sessionFactory.getCurrentSession();
        List<Plot> searchedLists = new ArrayList<Plot>();
        Map<String, Object> params = new HashMap<String,Object>();
        String hqlQuery = "from Plot where societyBlock.societyBlockId = :societyBlock";
        params.put( "societyBlock", societyId );
        if(plotType != null)
        {
            hqlQuery += " and type.typeId = :type";
            params.put( "type", plotType );
        }
        if(!plotSize.isEmpty() && plotSize != null && !plotSize.equals( "" ))
        {
            hqlQuery += " and size = :size";
            params.put( "size", plotSize );
        }
        if(min != null)
        {
            hqlQuery += " and price >= :pricemin";
            params.put( "pricemin", min );
        }
        if(max != null)
        {
            hqlQuery += " and price <= :pricemax";
            params.put( "pricemax", max );
        }
        Query query = session.createQuery( hqlQuery );

        for (String str : query.getNamedParameters())
        {
            query.setParameter( str, params.get( str ) );
        }
        searchedLists = (List<Plot>) query.list();
        System.out.println( searchedLists.size() );
        return searchedLists;
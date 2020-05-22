Query q = session.createNativeQuery("Select *, StatusId \n" +
        "FROM dbo.Structure AS S\n" +
        "JOIN dbo.StructureLocationType AS SLT ON SLT.StructureId = S.Id\n" +
        "WHERE SLT.LocationTypeId = 1080").addEntity(StructureEntity.class);

List<StructureEntity> zones2 = q.list();
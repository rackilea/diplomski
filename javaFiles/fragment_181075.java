return (ProductInfoExt) new PreparedSentence(s, "SELECT "
        + getSelectFieldList()
        + " FROM STOCKCURRENT AS C RIGHT JOIN PRODUCTS P ON (C.PRODUCT = P.ID) "
        + " WHERE (P.CODE = ? OR P.REFERENCE = ?) AND C.SITEGUID = ? ",
        new SerializerWriteBasicExt(new Datas[]{Datas.OBJECT, Datas.STRING, Datas.OBJECT, Datas.STRING, Datas.OBJECT, Datas.STRING}, new int[]{0, 1, 2}),
        ProductInfoExt.getSerializerRead()).find(sCode, sCode, siteGuid);
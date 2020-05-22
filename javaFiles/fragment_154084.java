Cursor c = db1.rawQuery("Select p.PrdImgURL, cp.PrdID " +
        "from Products as p " +
        "inner join CategoryProduct_MM as cp " +
        "on p.PrdID = cp.PrdID " +
        "inner join InventoryDB.Facing as f " +
        "on p.PrdID = f.PrdID " +
        "where cp.CategoryID == 1 and p.PrdImgURL is not null " +
        "order by f.`Order`", null);
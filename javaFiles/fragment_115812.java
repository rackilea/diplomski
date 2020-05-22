protected ResultSet getBarangList()throws SQLException, NullPointerException, ClassNotFoundException{
        String query = "SELECT * FROM tb_barang RIGHT JOIN tb_jenis ON tb_barang.kd_jenis = tb_jenis.kd_jenis ";
        if(resForListBarang == null){
            resForListBarang = alwaysDoResultSet(query);
        }
        return resForListBarang;
    }

    protected ResultSet getKolomBarangList() throws SQLException, Exception{
        String query = "SELECT * FROM tb_barang";
        if(getBarangKolom == null){
            getBarangKolom = alwaysDoResultSet(query);
        }
        return getBarangKolom;
    }
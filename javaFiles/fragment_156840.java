public ArrayList<String[]> listar(){

    String sql="select * from eventos";
    ArrayList<String[]> lista=new ArrayList<String[]>();
    try {
        st=con.createStatement();
        rs=st.executeQuery(sql);

        int NumColumnas=getRows(rs);

        while(rs.next()){
            String Fila[]=new String [NumColumnas];   
            for(int x=0;x<NumColumnas;x++){
                Fila[x]=rs.getObject(x+1).toString();
            }
             lista.add(Fila);
        }

    } catch (SQLException ex) {
        Logger.getLogger(EventosBean.class.getName()).log(Level.SEVERE, null, ex);
    }
    return lista;
}
if(!isEmpty)
{
 while(rs2.next()){
                   ps.setInt(1, rs2.getInt("NUM_DOSSIER"));
                   ps.setString(2, rs2.getString("INDICE"));
                   ps.setString(3, constitues.getString("OBSERVATIONS"));
                   ps.setInt(4, constitues.getInt("TYPE_CONSISTANCE"));
}
            }
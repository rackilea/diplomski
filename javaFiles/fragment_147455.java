sql.append("SELECT VGPT_EXE.* FROM ")
      .append(Constants.T_VW_GPT_E_BASIC)
      .append(" AS VGPT_EXE ")
      .append("WHERE VGPT_EXE.")
      .append(Constants.ID_SUBJECTE
      + " IN (");

for (int i = 0; i < ids.size(); i++) {
     if (i > 0) {
    sql.append(",");
        }
     sql.append("?");**for every dinamic id add an ?**
     parametres.add(ids.get(i));
     tipusParametres.add(new SqlParameter(Types.INTEGER));
}
    sql.append(")");
    sql.append(" AND VGPT_EXE." + Constants.ID_ENS_EXP + " = ? ");
                parametres.add(idEns);
                tipusParametres.add(new SqlParameter(Types.INTEGER));

                if (tipusDeute != null) {
                    if (tipusDeute.equals(ETipusDeute.HISTORIC)) {
                        sql.append(" AND " + Constants.DATA_FI_VOL
                                + " < TODAY ");
                    }
                    if (tipusDeute.equals(ETipusDeute.VIGENT)) {
                        sql.append(" AND " + Constants.DATA_FI_VOL
                                + " >= TODAY ");
                    }
                }
                // ordenació per la clau
                sql.append(ORDER_BY_E);
                try {

                pscf = new PreparedStatementCreatorFactory(sql.toString());
                // El resultset HA DE SER DEL TIPUS TYPE_SCROLL_INSENSITIVE
                pscf.setResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE);
                for (SqlParameter sp : tipusParametres) {
                    pscf.addParameter(sp);
                }

                resultat.setResultats((List<IDeute>) template.getJdbcOperations().query(pscf.newPreparedStatementCreator(parametres.toArray()), new ResultSetPaginatExtractor(new MapperDeute(), 
                        resultat.getFiles(), 
                        resultat.getInici())));
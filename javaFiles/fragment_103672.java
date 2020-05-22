ItemSqlParameterSourceProvider<NebefEffEdePdh> itemSqlParameter = nebefEffEdePdh -> new MapSqlParameterSource()
            .addValue("dateDebutBiMoins1Second",Utils.getDateMinusSeconds(nebefEffEdePdh.getDateDebutBi(), DELTA_DATE_DEBUT_FIN_BI))
            .addValue("dateJ", nebefEffEdePdh.getDateJ())
            .addValue("codeEde", nebefEffEdePdh.getCodeEde())
            .addValue("statutEffacement", nebefEffEdePdh.getStatutEffacement());
writer.setItemSqlParameterSourceProvider(itemSqlParameter);
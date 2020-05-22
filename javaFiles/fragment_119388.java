// Create sql
    RawSql rawSql = RawSqlBuilder.parse(sqlStringBuilder.getStrStatement())
            .columnMapping("g.id","id")
            .columnMappingIgnore("concat(g.client_id")
            .columnMappingIgnore("'-'")
            .columnMappingIgnore("trim(to_char(n.number")
            .columnMappingIgnore("'099999')))")
            .columnMappingIgnore("( SELECT sum(total_ttc) from global_commission_invoice_line where global_commission_invoice_id= g.id )")
            .create();
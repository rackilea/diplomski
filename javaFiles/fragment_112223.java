if(to.match(/^\d{4}[-]\d{2}[-]\d{2}$/) && from.match(/^\d{4}[-]\d{2}[-]\d{2}$/)) {
    var query = webCore.createQuery( webCore.marketAction.getDataSeries, {}, {
            FromDate: from,
            ToDate: to,
            Instrument: webCore.getInstrument(),
            hi__a : "0,1,2,4,21,8,10,11,12,9",
            OmitNoTrade: "true",
            ext_xslt_lang: currentLanguage,
            ext_xslt_options: "," + $("#adjustedId:checked").val() + ",", //$("#unadjustedId:checked").val() + ",",
            ext_xslt: "hi_table_shares_adjusted.xsl",
            ext_contenttype : "application/ms-excel",
            ext_contenttypefilename : "_" + webCore.getInstrument() + ".xls",
            ext_xslt_hiddenattrs: ",ip,iv,",
            ext_xslt_tableId: "historicalTable"
        }
    );
    $("#excelQuery").val( query );
    $("#excelForm").attr( "action", webCore.proxyURL ).submit();
}
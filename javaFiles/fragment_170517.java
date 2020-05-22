$.ajax({
        url : url,
        data : { keyType: SecurityKeyOther, sid: e13048f7-d253-4d50-acec-2981a5536d48},
        cache: false,
        success : function(result) {
            proccessLoginResult(result,function(){
                $("#loading").hide();
                $("#contentDiv").html(result);
                setOrgSelect();
                setCrumbs(srcObj);
            });
        }
    });
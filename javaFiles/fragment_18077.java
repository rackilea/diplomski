Executing stored procedure GET_EMP_PROJ (8):

{
    "storedProcedureName":"GET_EMP_PROJ",
    "columnCount":1,
    "records":[
        {
            "PROJ_ID":"VBASE"
        },
        {
            "PROJ_ID":"GUIDE"
        },
        {
            "PROJ_ID":"MKTPR"
        }
    ]
}


Executing stored procedure MAIL_LABEL (1015):

{
    "storedProcedureName":"MAIL_LABEL",
    "columnCount":6,
    "records":[
        {
            "LINE1":"GeoTech Inc.",
            "LINE2":"K.M. Neppelenbroek",
            "LINE3":"P.0.Box 702",
            "LINE4":"",
            "LINE5":null,
            "LINE6":"Netherlands    2514"
        }
    ]
}


Executing stored procedure ORG_CHART:

{
    "storedProcedureName":"ORG_CHART",
    "columnCount":5,
    "records":[
        {
            "HEAD_DEPT":null,
            "DEPARTMENT":"Corporate Headquarters",
            "MNGR_NAME":"Bender, Oliver H.",
            "TITLE":"CEO",
            "EMP_CNT":2
        },
        {
            "HEAD_DEPT":"Corporate Headquarters",
            "DEPARTMENT":"Sales and Marketing",
            "MNGR_NAME":"MacDonald, Mary S.",
            "TITLE":"VP",
            "EMP_CNT":2
        },
        // ... SNIP ...
        {
            "HEAD_DEPT":"Corporate Headquarters",
            "DEPARTMENT":"Finance",
            "MNGR_NAME":"Steadman, Walter",
            "TITLE":"CFO",
            "EMP_CNT":2
        }
    ]
}
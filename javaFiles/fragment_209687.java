// retrieve dummy Oracle Mm Java objects from the database
        OrdImage imgProxy = null;
        OrdImageSignature sigProxy = null;
        OracleCallableStatement cstmtOrdImageCreator = (OracleCallableStatement) conn.prepareCall(
                "DECLARE"
                + "  IMG ORDSYS.ORDIMAGE;"
                + "  SIG ORDSYS.ORDIMAGESIGNATURE;"
                + "  IMGBLOB BLOB;"
                + "  SIGBLOB BLOB;"
                + "BEGIN"
                + "  IMG := ORDImage.init();" // init an image
                + "  DBMS_LOB.CreateTemporary(IMG.source.localdata, TRUE);" // an emply BLOB for the image
                + "  SIG := ORDImageSignature.init();" // init a signature of the image
                + "  DBMS_LOB.CreateTemporary(SIG.signature, TRUE);" // an emply BLOB for its signature
                + "  ? := IMG;" // return both the image and its signature as values of output parameters
                + "  ? := SIG;"
                + "END;");
        try {
            cstmtOrdImageCreator.registerOutParameter(1,
                    OrdImage._SQL_TYPECODE, OrdImage._SQL_NAME);
            cstmtOrdImageCreator.registerOutParameter(2,
                    OrdImageSignature._SQL_TYPECODE, OrdImageSignature._SQL_NAME);
            cstmtOrdImageCreator.executeUpdate();
            imgProxy = (OrdImage) cstmtOrdImageCreator.getORAData(1, OrdImage.getORADataFactory());
            sigProxy = (OrdImageSignature) cstmtOrdImageCreator.getORAData(2, OrdImageSignature.getORADataFactory());
        } finally {
            cstmtOrdImageCreator.close();
        }
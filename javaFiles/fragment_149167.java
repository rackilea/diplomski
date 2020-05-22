List<Object[]> userRoleList = commonDao.findByNativeSQL(selectSQL
            , new Object[] {examCd, examPeriod, fromMemNo, toMemNo});
    for(Object[] row : userRoleList){
        CertificateDtlsVO cdObj = new CertificateDtlsVO();          
        cdObj.setExmCd(Integer.parseInt(row[0].toString()));
        cdObj.setExmDsc(row[1].toString());
        cdObj.setMemNo(row[2].toString());
        cdObj.setMemNm(row[3].toString());
        cdObj.setCertNo(row[4].toString());
        cdObj.setCertDt(row[5].toString());
        cdObj.setPrtNo(row[6].toString());
        cdObj.setSylCd(row[7].toString());
        cdObj.setNumOfTime(Integer.parseInt(row[8].toString()));
        cdObj.setMemType(row[9].toString());
        cdObj.setClassGrade(row[10].toString());
        InputStream photoBlob = ((Blob) row[11]).getBinaryStream();
        InputStream signBlob = ((Blob) row[12]).getBinaryStream();
        cdObj.setPhoto(IOUtils.toByteArray(photoBlob));
        cdObj.setSign(IOUtils.toByteArray(signBlob));
        memCertfDtlsList.add(cdObj);
    }
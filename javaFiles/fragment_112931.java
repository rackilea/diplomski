responseH = httpclient.execute(getHNMR);
    HttpEntity entityH = responseH.getEntity();
    HNMR = EntityUtils.toString(entityH);

    responseC = httpclient.execute(getCNMR);
    HttpEntity entityC = responseC.getEntity();
    CNMR = EntityUtils.toString(entityC);
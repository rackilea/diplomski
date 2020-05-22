List rhsList1 = new ArrayList();
    rhsList1.add(segmentDetailInfo);

    List rhsList2 = new ArrayList();
    rhsList2.add(segReqInfoBean);

    doProspecListCompareCheck(rhsList1);
    doProspecListCompareCheck(rhsList2);

}
private static void doProspecListCompareCheck(Object rhsList) {


     if (rhsList instanceof List) //wrong Check
         //DoTHIS
     else if(rhsList instanceof List)   //wrong Check       
         //Do THIS       

}
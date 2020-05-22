try {
    firstBatchOfTricky();
    secondBatchOfTricky();
    ....
    nthBatchOfTricky();
} catch (ItWentBoomException e) {
   // recover from boom
} catch (ItWentBangException e) {
   // recover from bang
}
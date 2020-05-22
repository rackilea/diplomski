Package p = myFactory.nextPackage();    // or something
if (p instanceof PrepaidPackage) {
    PrepaidPackage prepaid = (PrefpaidPackage)p;
    // and do the thing you want
} else if (p instanceof PostpaidPackage) {
    PostpaidPackage postpaid = (PostpaidPackage)p;
    // amd do the other things
}
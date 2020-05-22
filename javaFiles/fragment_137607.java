List<RoutePlanDayRequests> routePlanDayRequests = new ArrayList<RoutePlanDayRequests>();
// you can use the simpler syntax of the for-loop
for(Retailer retailer : retailers) {
    // create the requests object in the loop
    RoutePlanDayRequests requests = new RoutePlanDayRequests();
    Log.e("retailers",retailer.getId());
    requests.setPartnerId(retailers.get(i).getId());
    routePlanDayRequests.add(requests);
}
// call the service outside of the loop
updateServiceList(AppUtils.getMsisdn(mSharedPreferences), routePlanDayRequests);
}
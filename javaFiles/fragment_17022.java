ArrayList<DealerProductCount> retain =
        new ArrayList<DealerProductCount>(wsResponse.Dealers.size());
for (DealerProductCount dealer : wsResponse.Dealers) {
    if (dealer.ParentId == -10) {
        retain.add(dealer);
    }
}
// either assign 'retain' to 'wsResponse.Dealers' or ...
wsResponse.Dealers.clear();
wsResponse.Dealers.addAll(retain);
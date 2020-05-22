Iterator<DealerProductCount> it = wsResponse.Dealers.iterator();
while (it.hasNext()) {
    if (it.next().ParentId != -10) { 
        it.remove(); 
    }
}
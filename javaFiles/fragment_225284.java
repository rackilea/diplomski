Iterator<MyObject> itr = allAssets.iterator();
while (itr.hasNext()) {
  if (itr.next().getAssetType() != AssetType.BANK_ACCOUNT) {
    itr.remove();
  }
}
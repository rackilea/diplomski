for (int i = 0; i < fullNetworkArray.length(); i++) {
    Object network = fullNetworkArray.get(i);
    if (network == null) {
        fullNetworkArray.put(i, "");
    }
}
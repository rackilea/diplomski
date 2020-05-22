public void addBananas(Banana banana) {
    if(BananaHolder.hasRoom()) {
        BananaHolder.add(banana);
        fireBananaAdded(banana);  
    }
}

private void fireBananaAdded(Banana banana) {
    BananaAddedEvent event = new BananaAddedEvent(banana);
    for(BananaListener listener : listenersByType(Banana.class)) {
        listener.bananaAdded(event);
    }
}
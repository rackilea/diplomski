Arsenal arsenal = new Arsenal();

arsenal.put(new HandGrenade());
arsenal.put(new RocketLauncher());

Collection<HandGrenade> handGrenades = arsenal.get(HandGrenade.class);
Collection<RocketLauncher> rocketLaunchers = arsenal.get(RocketLauncher.class);
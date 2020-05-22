final Condition inService = new Condition();
            provider.addObserver(new ProviderObserver() {
                public void providerChangedEvent(ProvEv[] eventList) {
                    if (eventList == null) {
                        return;
                    }
                    for (int i = 0; i < eventList.length; ++i) {
                        if (eventList[i] instanceof ProvInServiceEv) {
                            inService.set();
                        }
                    }
                }
            });
            inService.waitTrue();
            Address srcAddr = provider.getAddress(src);
            co = new CallObserver() {
                public void callChangedEvent(CallEv[] eventList) {    
                }
            };
            srcAddr.addCallObserver(co);
            call = provider.createCall();
            call.connect(srcAddr.getTerminals()[0], srcAddr, dst);
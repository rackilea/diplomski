ManagedMessagingService ms = NettyMessagingService.builder()
                .withAddress(network[id])
                .build();

//(...)
ms.start();

ms.registerHandler("leader", (o,m) -> {
    //...
});
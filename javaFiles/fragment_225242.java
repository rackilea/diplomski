private final Transport protonTransport = Proton.transport();
private final Connection protonConnection = Proton.connection();

...

this.protonTransport.setMaxFrameSize(maxFrameSize);
this.protonTransport.setChannelMax(CHANNEL_MAX);

this.protonTransport.bind(this.protonConnection);
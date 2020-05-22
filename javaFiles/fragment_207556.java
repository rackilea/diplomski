List<ChannelFuture> futures = new ArrayList<>();
futures.add(bootstrap.bind(this.socketAddress(IPV4, 80)));
futures.add(bootstrap.bind(this.socketAddress(IPV4, 443)));
futures.add(bootstrap.bind(this.socketAddress(IPV6, 80)));
futures.add(bootstrap.bind(this.socketAddress(IPV6, 443)));

for (ChannelFuture f: futures) {
    f.sync();
}
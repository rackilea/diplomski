//return all v4 addresses
static def getLocalIPv4() {
    def ip4s = []
    NetworkInterface.getNetworkInterfaces()
            .findAll { it.isUp() && !it.isLoopback() && !it.isVirtual() }
            .each {
        it.getInetAddresses()
                .findAll { !it.isLoopbackAddress() && it instanceof Inet4Address }
                .each { ip4s << it.getHostAddress() }
    }
    return ip4s
}
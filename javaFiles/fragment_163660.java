// AbstractXMPPConnection.java

if (config.hostAddress != null) {
            hostAddresses = new ArrayList<>(1);
            HostAddress hostAddress = new HostAddress(config.port, config.hostAddress);
            hostAddresses.add(hostAddress);
        }
        else if (config.host != null) {
            hostAddresses = new ArrayList<HostAddress>(1);
            HostAddress hostAddress = DNSUtil.getDNSResolver().lookupHostAddress(config.host, config.port, failedAddresses, config.getDnssecMode());
            if (hostAddress != null) {
                hostAddresses.add(hostAddress);
            }
        } else {
            // N.B.: Important to use config.serviceName and not AbstractXMPPConnection.serviceName
            hostAddresses = DNSUtil.resolveXMPPServiceDomain(config.getXMPPServiceDomain().toString(), failedAddresses, config.getDnssecMode());
        }
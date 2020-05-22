// 123.11.1.1, 123.1.1.12, 123.322.12.1
    String[] list = merchant.getAllowed_ip_address().split(",");

    String ip = request.getRemoteAddr();

    for (String allowedIP : list) {
        if (!ip.trim().equals(allowedIP.trim())) {
            // Not in list
        }
    }
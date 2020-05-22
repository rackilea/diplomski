package com.stackoverflow;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class GetHWAddresses {
    public static void main(String[] args) throws SocketException {
    final Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();
        while (e.hasMoreElements()) {
            final byte [] mac = e.nextElement().getHardwareAddress();
            if (mac != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < mac.length; i++)
                    sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
                System.out.println(sb.toString());
            }
        }
    }
}
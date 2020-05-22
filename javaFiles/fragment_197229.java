long mStartRX = TrafficStats.getTotalRxBytes();
...
long rxBytes = TrafficStats.getTotalRxBytes()- mStartRX;

RX.setText(rxBytes + " Bytes");
RX.setText(String.format("%.2f MB",rxBytes /(1024f*1024f)));
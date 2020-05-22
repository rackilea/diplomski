//The actionpreformed by the button
   SwingWorker worker = new SwingWorker<Void, Void>() {
            @Override
        // All actions are done this method
            protected Void doInBackground() throws Exception {
                String ip = "";
                String mac = "";
                String manufacturer = "";
                String ports = "";
                String hostname = "";
                String title = "";
                tableModel.setRowCount(0);
                PingScan p = new PingScan();
                List<Future<String>> scanResult = p.checkThisIP(jFormattedTextField1.getText(), jFormattedTextField2.getText());
                for (final Future<String> f : scanResult) {
                    try {
                        ip = f.get();
                        if (!ip.equals("")) {
                            arp ARP = new arp();
                            PortScan openPort = new PortScan();
                            IP ipClass = new IP();
                            mac = ARP.getMac(ip);
                            manufacturer = ARP.getOUI(mac);
                            ports = openPort.checkIpForPorts(ip);
                            hostname = ipClass.hostname(ip);
                            title = ipClass.htmlTitle(ip);
                            Object[] data = {ip, mac, manufacturer, ports, hostname, title};
                            tableModel.addRow(data);
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                return null;
            }
        };
     worker.execute();
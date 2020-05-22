new Thread(new Runnable() {
    String result = "";

    public void run() {
        for (String theURL : IPArray) {
            try {
                URL url = new URL(theURL);
                InetAddress address = InetAddress.getByName(url.getHost());
                String temp = address.toString();
                String IP = temp.substring(temp.indexOf("/") + 1, temp.length());
                URLArray.add(IP);
                Progress.percentage = (URLArray.size() * 100) / Progress.totalToDo;
                Progress.ipProgress.setString(Progress.percentage + "%");
                Progress.ipProgress.setValue(Progress.percentage);
                Progress.ipProgress.repaint();
                result += IP + System.getProperty("line.separator");
            } catch (Exception e) {
                if ("www.".equals(e.getMessage())) {
                    JOptionPane.showMessageDialog(
                            null, "Incorrect URL. Usage: http://www.URL.com\nError = Space! Can't use gaps in list.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        IPFrame.textAreaIP.setText(result);
        GEOLookup.check(IPFrame.textAreaIP.getText());
    }
}).start();
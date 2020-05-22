import java.net.Socket;

String xline;

while (clientSocket.isConnected()) {

    BufferedReader xreader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream(), StandardCharsets.UTF_8));

    if (xreader.ready()) {

        while ((xline = xreader.readLine()) != null) {
                xline = xline.trim();

            if (xline != null && !xline.trim().isEmpty()) {

                if (xline.contains("MDRAWEVENT")) {

                    String coordinates = xline.replace("MDRAWEVENT", "");
                    String[] tokens = coordinates.split(Pattern.quote(":"));
                    Point[] moviments = new Point[tokens.length];

                    for (int i = 0; i < tokens.length; i++) {
                       String[] coordinates = tokens[i].replace("{", "").replace("}", "").split(",");

                       int x = Integer.parseInt(coordinates[0].split("=")[1]);
                       int y = Integer.parseInt(coordinates[1].split("=")[1]);

                       moviments[i] = new Point(x, y);
                    }

                    MyAccessibilityService.instance.mouseDraw(moviments, 2000);
                }
            }
        }
    }
}
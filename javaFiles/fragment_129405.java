try {
        HtmlPage points = (HtmlPage) webClient.getPage("https://www.hockey-reference.com/leaders/points_career.html");
        String pointsPageContent = points.asText();

        HtmlPage assists = (HtmlPage) webClient.getPage("https://www.hockey-reference.com/leaders/assists_career.html");
        String assistsPageContent = assists.asText();

        if (input.equals("Points")) {
            System.out.println(pointsPageContent);

        } else if (input.equals("Assists")) {
            System.out.println(assistsPageContent);
        } else {
            System.out.println("not a valid entry, please type either 'Points' or 'Assists' to see the stats for the corresponding category");
        }
    } catch (IOException ex) {
        ex.printStackTrace(); // Capture and treat errors
    }
try {
        doc = Jsoup
                .connect(
                        "https://pilotweb.nas.faa.gov/PilotWeb/notamRetrievalByICAOAction.do?method=displayByICAOs")
                .data("retrieveLocId", airfield[0])
                .data("formatType", "ICAO")
                .data("reportType", "REPORT")
                .data("actionType", "notamRetrievalByICAOs")
                // .userAgent("Mozilla")
                // .cookie("auth", "token")
                .timeout(3000).post();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
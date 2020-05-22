Document doc = Jsoup
    .connect("http://www.wettportal.com/lib/ajax/getArchivedEvents.php")
    .data("sport_id", "4")
    .data("region_id", "16")
    .data("league_id", "0")
    .data("fromdate", "")
    .data("tilldate", "")
    .data("team", "")
    .header("X-Requested-With", "XMLHttpRequest")
    .timeout(10000)
    .get();
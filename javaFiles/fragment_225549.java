public static String generateLeague(String match) {

  String club = null;
  String league;
  if (match.toLowerCase().contains(" ")) {
    club = match.toLowerCase().substring(0, match.indexOf(" "));
  } else {
    club = match;
  }
  switch (club) {
    case "arsenal":
    case "bournemouth":
    case "burnley":
    case "chelsea":
    case "crystal":
    case "everton":
    case "hull":
    case "leicester":
    case "liverpool":
    case "manchester":
    case "middlesborough":
    case "southampton":
    case "stoke":
    case "sunderland":
    case "swansea":
    case "tottenham":
    case "watford":
    case "west":
        league = "Premier League";
        break;
    case "angers":
    case "bastia":
    case "bordeaux":
    case "caen":
    case "dijon":
    case "guingamp":
    case "lille":
    case "lorient":
    case "lyon":
    case "marseille":
    case "metz":
    case "monaco":
    case "montpellier":
    case "nancy":
    case "nantes":
    case "nice":
    case "psg":
    case "rennes":
    case "saint-ettiene":
    case "toulouse":
        league = "Ligue 1";
        break;
    case "alavés":
    case "athletic":
    case "atlético":
    case "barcelona":
    case "celta":
    case "deportivo":
    case "eibar":
    case "espanyol":
    case "granada":
    case "las":
    case "leganes":
    case "malaga":
    case "osasuna":
    case "real":
    case "sevilla":
    case "sporting":
    case "valencia":
    case "villarreal":
        league = "La Liga";
        break;
    case "1.":
    case "1899":
    case "bayer":
    case "bayern":
    case "borussia":
    case "darmstadt":
    case "eintracht":
    case "fc":
    case "hamburger":
    case "hertha":
    case "mainz":
    case "rb":
    case "sc":
    case "schalke":
    case "vfl":
    case "werder":
        league = "Bundesliga";
        break;
    case "ac":
    case "as":
    case "atalanta":
    case "bologna":
    case "cagliari":
    case "chievo":
    case "crotone":
    case "empoli":
    case "fiorentina":
    case "genoa":
    case "internazionale":
    case "juventus":
    case "lazio":
    case "napoli":
    case "palermo":
    case "sampdoria":
    case "sassuolo":
    case "torino":
    case "udinese":
    case "us":
        league = "Seria A";
        break;
    default: league = null;

  }

  return league;
}
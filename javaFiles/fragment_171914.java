public class MatchPage extends Activity {
private String locali= null;
private String ospiti= null;
private TextView localiTV;
private TextView ospitiTV;
private MatchRugby partita;
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);     
    setContentView(R.layout.match);
     localiTV =(TextView) findViewById(R.id.localiTV);
     ospitiTV =(TextView) findViewById(R.id.ospitiTV);
    getLocali();
    getOspiti();
    createMatch();

     localiTV.setText("Locali /n"+ partita.teamA.getName());
     ospitiTV.setText("Ospiti /n"+ partita.teamB.getName());

}

/**
 * Prende il nome della squadra locale dall'intent
 * @return
 */
public String getLocali(){
    if (locali == null) {
      Intent matchStart = getIntent();
      locali = matchStart.getStringExtra(NewMatchPage.LOCALI);
    }
    return locali;
}

/**
 * prende il nome della squadra ospite dall'intent
 * @return
 */
public String getOspiti(){
    if (ospiti == null) {
      Intent matchStart = getIntent();
      ospiti = matchStart.getStringExtra(NewMatchPage.OSPITI);
    }
    return ospiti;
}

public MatchRugby createMatch(){
    TeamRugby teamLocali= new TeamRugby(locali);
    TeamRugby teamOspiti= new TeamRugby(ospiti);
    partita = new MatchRugby(teamLocali, teamOspiti);
    return partita
}

  private String locali
  private String ospiti
  private MatchRugby partita
}
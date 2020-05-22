public class AddCompetitionResult extends Fragment {

    private CompetitionResultListAdapter competitionResultListAdapter;
    private DataManager datamanager;
    ArrayList<Result> result;
    ListView listView;
    private Horse horse;
    private Button addResults;
    int clickCounter=0;
    int resultId = 1;

    public AddHorseCompetitionResult(ArrayList<Result> result, 
     Horse horse) {
        this.horse = horse;
       /*Initialize here if you 
       passed the value somewhere (1)*/
        this.result = result; 
    }

    public View onCreateView(LayoutInflater inflater, 
    ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.
        add_horse_competition_result, null);

        /*Haven't passed the value to constructor*/
        /*anywhere then do this (2)*/
        result = new ArrayList<Result>();
        result.add(new Result("resultId")); 
        return view;

    }
}
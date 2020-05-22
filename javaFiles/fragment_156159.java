public class VocabularyFragment extends Fragment {

View rootview;
@Nullable
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    rootview = inflater.inflate(R.layout.fragment_vocab_list,container, false);
    initialVocabList(rootview);
    return rootview;
 }
}
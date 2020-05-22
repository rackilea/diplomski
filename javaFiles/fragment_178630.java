private TextView txtName, txtKind;

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View rootView = inflater.inflate(R.layout.fragment_question_detail, container, false);

    txtName = (TextView) rootView.findViewById(R.id.textQuestion);
    txtKind = (TextView) rootView.findViewById(R.id.textKind);

    // TODO: Read the link how to use these
    Bundle arguments = getArguments();

    Question question = QuestionCatalog.getQuestionCatalog()
                .getQuestionList().getList().get((int) questionId);
    showQuestion(question);

    return view;
}

private void showQuestion(Question q) {
    txtName.setText(q.getName());
    txtKind.setText(q.getKind());
}
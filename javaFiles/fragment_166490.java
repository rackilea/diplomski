public class LiveTestAdapter extends RecyclerView.Adapter<LiveTestAdapter.CustomViewHolder> {

    private int mItemSelected = -1;
    private List<DmLiveQuiz> questionList;

    private int[] answerList; // Get a list of your answers here.

    private DmLiveQuiz questionsList;
    private Context context;
    final DataHolder dh = new DataHolder();
    public List<Integer> myResponse = new ArrayList<Integer>();
    public int qno;
    public String myQno;
    public int afterSub;
    DataHolder dataHolder;

    public LiveTestAdapter(List<DmLiveQuiz> questionList, Context context) {
        this.questionList = questionList;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.live_quiz_display_format, parent, false);
        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final CustomViewHolder holder, int position) {

        questionsList = questionList.get(holder.getAdapterPosition());
        holder.tvQNo.setText(questionsList.getQuestionId() + "");
        holder.tvquestion.getLayoutParams().width = LinearLayout.LayoutParams.WRAP_CONTENT;
        holder.tvquestion.setText(questionsList.getQuestion());
        holder.optA.setText(questionsList.getOptA());
        holder.optB.setText(questionsList.getOptB());
        holder.optC.setText(questionsList.getOptC());
        holder.optD.setText(questionsList.getOptD());

        // Now you need to modify the backgrounds of your option buttons like the following.
        if (answerList[position] == 1) holder.optA.setBackgroundResource(R.drawable.button_border);
        else holder.optA.setBackgroundResource(R.drawable.button_question_style);

        if (answerList[position] == 2) holder.optB.setBackgroundResource(R.drawable.button_border);
        else holder.optB.setBackgroundResource(R.drawable.button_question_style);

        if (answerList[position] == 3) holder.optC.setBackgroundResource(R.drawable.button_border);
        else holder.optC.setBackgroundResource(R.drawable.button_question_style);

        if (answerList[position] == 4) holder.optD.setBackgroundResource(R.drawable.button_border);
        else holder.optD.setBackgroundResource(R.drawable.button_question_style);

        holder.optA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.optA.setBackgroundResource(R.drawable.button_border);
                answerList[position] = 1; // Selected first option which is A
                Toast.makeText(context, "Position :" + holder.getAdapterPosition(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.optB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.optB.setBackgroundResource(R.drawable.button_border);
                answerList[position] = 2; // Selected second option which is B
                Toast.makeText(context, "Position :" + holder.getAdapterPosition(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.optC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.optC.setBackgroundResource(R.drawable.button_border);
                answerList[position] = 3; // Selected third option which is C
                Toast.makeText(context, "Position :" + holder.getAdapterPosition(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.optD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.optD.setBackgroundResource(R.drawable.button_border);
                answerList[position] = 4; // Selected fourth option which is D
                Toast.makeText(context, "Position :" + holder.getAdapterPosition(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.tvClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.optA.setBackgroundResource(R.drawable.button_question_style);
                holder.optB.setBackgroundResource(R.drawable.button_question_style);
                holder.optC.setBackgroundResource(R.drawable.button_question_style);
                holder.optD.setBackgroundResource(R.drawable.button_question_style);
                answerList[position] = 0; // Clear the value in the answerList
            }
        });
    }

    // Use this function to set the question list in the adapter
    public void setQuestionList(List<DmLiveQuiz> questionList) {
        this.questionList = questionList;
        this.answerList = new int[questionList.size()]; // This initializes the answer list having the same size as the question list
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return questionList.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView tvquestion, tvClear, tvQNo;
        Button optA, optB, optC, optD;

        public CustomViewHolder(View itemView) {
            super(itemView);
            tvQNo = (TextView) itemView.findViewById(R.id.tvLiveQuizQuestionNo);
            tvquestion = (TextView) itemView.findViewById(R.id.tvLiveQuizQuestion);
            optA = (Button) itemView.findViewById(R.id.buttonOptionA);
            optB = (Button) itemView.findViewById(R.id.buttonOptionB);
            optC = (Button) itemView.findViewById(R.id.buttonOptionC);
            optD = (Button) itemView.findViewById(R.id.buttonOptionD);
            tvClear = (TextView) itemView.findViewById(R.id.tvClearSelection);
        }
    }
}
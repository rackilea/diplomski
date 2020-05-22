public void newAddButtonToLayout (Context context)
{
int counter = 1;

LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.MATCH_PARENT,
        300);
params.weight = 1f;
params.setMargins(10,10,10,10);

LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.MATCH_PARENT,
        LinearLayout.LayoutParams.WRAP_CONTENT);
layoutParams.gravity = Gravity.RIGHT;

ArrayList<LinearLayout> rows = new ArrayList<>();

for (int i = 0; i < buttons.size(); i++)
{
    if (counter == buttons.get(i).getId())
    {
        LinearLayout row = new LinearLayout(context);
        row.setId(1000 + i);

        row.setLayoutParams(layoutParams);

        if(i <= buttons.size()) {
            if(i == buttons.size()) {
                if(buttons.size() % 2 == 0) {
                    buttons.get(i - 1).setLayoutParams(params);
                    row.addView(buttons.get(i - 1));
                }
            } else {
                buttons.get(i - 1).setLayoutParams(params);
                row.addView(buttons.get(i - 1));
            }

        }

        buttons.get(i).setLayoutParams(params);
        row.addView(buttons.get(i));
        //relativeLayout.addView(buttons.get(i));



        relativeLayout.addView(row);



        counter += 2;

        System.out.println(buttons.get(i).getId() + " BUTTON HERE");

        //rows.add(row);

    }
    if(i == buttons.size()-1) {
        System.out.println("IT IS IN THE LOOP");
        if(buttons.size() % 2 != 0) {
            buttons.get(i).setLayoutParams(params);
            relativeLayout.addView(buttons.get(buttons.size()-1));
        }
    }
}
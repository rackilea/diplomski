class MeinClickListener implements OnClickListener
{
    public void onClick(View v)
    {
        String text = "Es wurde geklickt";
        Toast t = Toast.makeText(v.getContext(), text, Toast.LENGTH_SHORT);

        t.show();
    }

}
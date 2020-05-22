bContinue.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

            eIntensity = eERHIntensity.getText().toString();
            ePercent = eERHPercent.getText().toString();
            pIntensity = ePRHIntensity.getText().toString();
            pPercent = ePRHPercent.getText().toString();
            Intent nextActivity = new Intent(getApplicationContext(), TumorSize.class);
            nextActivity.putString("eIntensity",eIntensity);
            nextActivity.putString("ePercent",ePercent);
            nextActivity.putString("pIntensity",pIntensity);
            nextActivity.putString("pPercent",pPercent);
            startActivity(nextActivity);
    }
});
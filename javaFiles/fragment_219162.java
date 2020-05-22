final String prefix = "ttj.android.ft.teams.";
for (int i = 0; i < teams.length; i++) {
    tv = (TextView) findViewById(teams[i]);
    tv.setOnClickListener(new View.OnClickListener() {
       public void onClick(View v) {
       try {
          Class class = Class.forName(prefix + teamnames[i]);               
          Intent open = new Intent(Transfers.this, class);
          startActivity(open);
        } catch (ClassNotFoundException e) {
          e.printStackTrace();
        }
    });
}
;
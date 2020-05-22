private void addLesson() {
    String pamoka = et_pam_pav.getText().toString();
    String kelintadienis = et_pam_kelintad.getText().toString();
    String kelinta_pamoka = et_pam_nr.getText().toString();
    TvarkarastisInformation tvarkarastisInformation = new TvarkarastisInformation(pamoka, kelintadienis, kelinta_pamoka);

    DatabaseReference pirmadienisRef = databaseReference.child("timetable").child(user.getUid()).child("Pirmadienis");
    String key = pirmadienisRef.push().getKey();
    pirmadienisRef.child(key).setValue(tvarkarastisInformation);
}
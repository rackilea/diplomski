public void addPlane(View view){
    PlaneInfo plane = new PlaneInfo();

    EditText editPlaneName = (EditText) findViewById(R.id.input_plane_name);
    plane.setType(editPlaneName.getText().toString());

    EditText editPlaneType = (EditText) findViewById(R.id.plane_type);
    plane.setType(editPlaneType.getText().toString());

    Spinner spinnerPlaneClass = (Spinner) findViewById(R.id.spinner);
    plane.setType(spinnerPlaneClass.getSelectedItem().toString());

    Spinner spinner1PlaneStyle = (Spinner) findViewById(R.id.spinner2);
    plane.setType(spinner1PlaneStyle.getSelectedItem().toString());

    EditText editPlaneNotes = (EditText) findViewById(R.id.plane_notes);
    plane.setType(editPlaneNotes.getText().toString());

    dbHandler.addPlane(plane);
}
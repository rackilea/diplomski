if(!editTextCgpa.getText().toString().isEmpty()){
Float cgpa = Float.parseFloat(editTextCgpa.getText().toString());
 if(cgpa<=4.00 && cgpa > 0.00 ){
                student.setCgpa(cgpa);
            }
            else{
                error = true;
                editTextCgpa.setError("CGPA must be within 4 in scale");
            }
}
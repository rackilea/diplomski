setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mProgress.setVisibility(View.VISIBLE);
            edit_btn.setVisibility(View.INVISIBLE);
            String new_text = edit_text.getText().toString();
            mFirestore.collection("Text").document(text_id).update("body", new_text).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(EditActivity.this, R.string.changes, Toast.LENGTH_LONG).show();
                        Intent intent = new Intent();
                        intent.putExtra("newText", new_text);
                        //Return the position s well
                        intent.putExtra("position", position);
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                    else{
                        String error = task.getException().getMessage();
                        Toast.makeText(EditActivity.this, R.string.error + error, Toast.LENGTH_LONG).show();
                    }
                    mProgress.setVisibility(View.INVISIBLE);
                    edit_btn.setVisibility(View.VISIBLE);
                }
            });
        }
    });
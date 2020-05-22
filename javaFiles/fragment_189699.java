holder.copyButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){


                myClipboard = (ClipboardManager) v.getContext().getSystemService(Context.CLIPBOARD_SERVICE);


                myClip = ClipData.newPlainText("label", holder.content.getText().toString());
                myClipboard.setPrimaryClip(myClip);
                Toast.makeText(v.getContext(), "Copied to clipboard" , Toast.LENGTH_SHORT ).show();

            }
        });
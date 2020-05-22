imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setDataAndType(Uri.parse(obj.getStremURL()), "video/*");
                startActivity(Intent.createChooser(intent, "Complete action using"));
            }
        });
TextView textView = (TextView)findViewById(R.id.textView1);
        Shader textShader=new LinearGradient(0, 0, 0, 20,
                new int[]{getResources().getColor(R.color.violet),getResources().getColor(R.color.indigo),
                getResources().getColor(R.color.blue),
                getResources().getColor(R.color.green),
                getResources().getColor(R.color.yellow),
                getResources().getColor(R.color.orange),
                getResources().getColor(R.color.red)},
                new float[]{0,0.2f,0.4f,0.6f,0.8f,0.9f,1}, TileMode.CLAMP);
        textView.getPaint().setShader(textShader);
        textView.setTextSize(20);
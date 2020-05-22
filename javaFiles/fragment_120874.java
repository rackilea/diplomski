button1.setOnClickListener(new View.OnClickListener() {  
            @Override  
              public void onClick(View view) {  
                Bundle bundle1 = new Bundle(); 
                bundle1.putInt("button id", button_1); 
                bundle1.putInt("top", R.drawable.1);  
                bundle1.putInt("mid", R.drawable.2);  
                bundle1.putInt("bot", R.drawable.3);  
                Intent intet1 = new Intent(curclass.this, nextclass.class);  
                intent1.putExtras(bundle1);  
                startActivity(intent1);
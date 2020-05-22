button2.setOnClickListener(new View.OnClickListener() {  
            @Override  
              public void onClick(View view) {  
                Bundle bundle2 = new Bundle();  
                bundle2.putInt("button id", button_2);
                bundle2.putInt("top", R.drawable.1);  
                bundle2.putInt("mid", R.drawable.2);  
                bundle2.putInt("bot", R.drawable.3);  
                Intent intet2 = new Intent(curclass.this, nextclass.class);  
                intent2.putExtras(bundle1);  
                startActivity(intent1);
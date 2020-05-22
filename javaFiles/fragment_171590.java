Bundle bundle = getArguments();
if (bundle != null) {
    ArrayList<Integer> s = bundle.getIntegerArrayList("IMAGE");
    if (s != null) {
        for(int i=0;i<s.size();i++){
             switch(i){
                 case 0 : circleImageView1.setImageResource(s.get(i));
                          break; 
                 case 1 : circleImageView2.setImageResource(s.get(i));
                          break;
                 case 2 : circleImageView3.setImageResource(s.get(i));
                          break;
                 case 3 : circleImageView4.setImageResource(s.get(i));
                          break;
                 case 4 : circleImageView5.setImageResource(s.get(i));
                          break;
                 case 5 : circleImageView6.setImageResource(s.get(i));
                          break;
                 default: break;
             }
        }
    }
}
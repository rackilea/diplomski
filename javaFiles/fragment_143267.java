case R.id.bt1:
                AlphaAnimation alphaAnimation1 = new AlphaAnimation(0, 1);
                alphaAnimation1.setDuration(300);
                alphaAnimation1.setFillAfter(true);
                bt1.startAnimation(alphaAnimation1);
                aaa = (int) bt1.getTag();
                bt1.setClickable(false);

                if(bbb==0){
                    bt1.setClickable(false);
                    bbb = aaa;
                    bbbID = v1.getId();   //////change
                }else if (bbb==aaa){
                    right++;
                    tvtext.setText("Right" + right + "wRONG" + wrong);
                    bbb=0;
                    bbbID = 0;   //////change

                }else{
                    wrong++;
                    tvtext.setText("Right" + right + "wRONG" + wrong);
                    bbb=0;
                    AlphaAnimation alphaAnimation = new AlphaAnimation(1,0);
                    alphaAnimation.setDuration(600);
                    alphaAnimation.setFillAfter(true);
                    bt1.startAnimation(alphaAnimation);
                    bt1.setClickable(true);
                    for(int i=0;i<buttons.size();i++){   //////change
                       if(buttons.get(i).getId() == bbbID){   //////change
                           buttons.get(i).setClickable(true);   //////change
                       }
                    }
                    }
                break;
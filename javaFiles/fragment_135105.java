int count = screenSlidePagerAdapter .getCount();
    for(int i=0;i<count;i++){
        Fragment fragment = screenSlidePagerAdapter .getItem(i);
        if(fragment instanceof GaugeFragment){
            ((GaugeFrament)fragment).gaugeFragmentMethod(data);
            break;
        }
        else if(fragment instanceof OtherTypeOfFragment){
            ((OtherTypeOfFragment)fragment).otherTypeOfFragmentMethod(data);
            break;
        }
    }
case 8:
        params = new RelativeLayout.LayoutParams(180, 144);
        switch(count){
        case 1:

            params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            params.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            params.width = 180;
            params.height = 324;
            params.setMargins(300, 40, 30, 0);
            break;
        case 2:
            params.addRule(RelativeLayout.RIGHT_OF, 1);
            params.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            params.width = 180;
            params.height = 324;
            params.setMargins(20, 40, 30, 0);
            break;
        case 3:
            params.width = 180;
            params.height = 324;
            params.addRule(RelativeLayout.RIGHT_OF, 2);
            params.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            params.setMargins(0, 40, 30, 0);
            break;
        case 4:
            params.width = 180;
            params.height = 324;
            params.addRule(RelativeLayout.RIGHT_OF, 3);
            params.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            params.setMargins(0, 40, 30, 0);
            break;
        case 5:
            params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            params.width = 180;
            params.height = 324;
            params.setMargins(40, 0, 300, 0);
            break;
        case 6:
            params.addRule(RelativeLayout.LEFT_OF, 5);
            params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            params.height = 324;
            params.width = 180;
            params.setMargins(40, 0, 0, 0);
            break;
        case 7:
            params.addRule(RelativeLayout.LEFT_OF, 6);
            params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            params.width = 180;
            params.height = 324;
            params.setMargins(40, 0, 0, 0);
            break;
        case 8:
            params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            params.width = 180;
            params.height = 324;
            params.addRule(RelativeLayout.LEFT_OF, 7);
            break;
        default:
            break;
        }
        break;
    default:
        break;
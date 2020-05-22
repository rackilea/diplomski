case 'W':
    tempBal = balbefore - transamount;
    if(tempBal < 0) {
        System.out.println("Insufficient Funds");
    }
    else {
        balafter = balbefore - transamount;
        if(balafter < 300) {
            System.out.println("Warning, balance below $300");
        }
    }
    break;
...
default:
    System.out.println("Please select "D", "W", or "R");
    break;
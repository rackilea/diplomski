public boolean abbaMatcher(String abba)
{
    int state = 0;
    int symbol = 0;


    while (symbol < abba.length()){
        char c = abba.charAt(symbol);
        switch (state){
            case 0: if(c == 'a'){
                        state = 1;
                    }else{
                        state = 0;
                    };
                    break;
            case 1: if(c == 'b'){
                        state = 2;
                    }else{
                        state = 1;
                    };
                    break;
            case 2: if(c == 'b'){
                        state = 3;
                    }else{
                        state = 1;
                    };
                    break;
            case 3: if(c == 'a'){
                        return true;
                    }else{
                        state = 0;
                    };
                    break;
        }
        symbol++;
    }

    return false;
}
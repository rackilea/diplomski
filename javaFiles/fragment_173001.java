switch(test) {
        case '1':
        case '0':
        case 'x':
        case 'X':
           out.add(fromString(test));
           break;
        case ' ':
        case '\t':
           break;
        default:
           throw new ExceptionLogicMalformedSignal;
     }
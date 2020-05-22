switch (EventType) {
        case XMLStreamConstants.CHARACTERS:
        case XMLStreamConstants.CDATA:
            System.out.println(r.getText());
            break;
        default:
            break;
        }
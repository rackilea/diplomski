String getStatusCode(String status) {
        switch (status) {
            case "Processing":
                return "0";
            case "Room is Allotted":
                return "1";
            case "Sorry All Rooms Are Full":
                return "2";
            case "Living":
                return "3";
            case "Left":
                return "4";
            default:
                return "default_value";
        }
    }
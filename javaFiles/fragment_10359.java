String name = "Mary Jane Lee";
    String arr[] = name.split (" ");

    switch (arr.length) {
        case 1:
            System.out.println(name);
            break;
        case 2:
            System.out.println(arr[1] + ", " + arr[0]);
            break;
        default:
            System.out.println(arr[2] + ", " + arr[0] + " " + arr[1]);  
    }
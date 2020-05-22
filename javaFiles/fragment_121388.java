for (int i = 1; i <= c; i++) {
    switch (i % 8) {
        case 1: System.out.println("One potato"); break;
        case 2: System.out.println("two potato"); break;
        case 3: System.out.println("three potato"); break;
        case 4: System.out.println("four..."); break;
        case 5: System.out.println("five potato"); break;
        case 6: System.out.println("six potato"); break;
        case 7: System.out.println("seven potato"); break;
        case 0: System.out.println("more!"); break;
        default: break;
    }
}
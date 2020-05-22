List myList = new ArrayList();

    // 5. outputs: false
    System.out.println(myList instanceof java.util.Map);

    // 6. outputs: false
    System.out.println(myList instanceof java.util.HashMap);

    ArrayList myArrayList = new ArrayList();

    // 7. outputs: false
    System.out.println(myArrayList instanceof java.util.Map);

    // 8. COMPILATION ERROR
    System.out.println(myArrayList instanceof java.util.HashMap);
try {
    // Execute code
} catch(MyException e) {
    System.out.println(e.getMessage());
} catch(MyNextException e) {
    System.out.println(e.getMessage());
}
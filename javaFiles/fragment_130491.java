public static void main(String[] args) {
    try {
        int a = 10 / 0;
    } catch (ArithmeticException e) {
        Exce(e);
    } catch (NullPointerException e) {
        Exce(e);            
    } catch (Exception e) {
        Exce(e);
    }
}
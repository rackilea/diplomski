public class Bean {
    private String id; // +getter+setter

    public void onload(PhaseEvent event) {
        // Value of id is available here.
        System.out.println(id); // 123
    }

    // ...
}
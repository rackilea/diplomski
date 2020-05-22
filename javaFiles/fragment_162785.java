public class ModelSurcharge {
    private LocalDate cNoteDate;
    private int cNote;
    private double surcharge;

    public ModelSurcharge(LocalDate cNoteDate, int cNote, double surcharge) {
        this.cNoteDate = cNoteDate;
        this.cNote = cNote;
        this.surcharge = surcharge;
    }

    public LocalDate getcNoteDate() {
        return cNoteDate;
    }

    public int getcNote() {
        return cNote;
    }

    public double getSurcharge() {
        return surcharge;
    }

    public static void main(String[] args) {
        List<ModelSurcharge> surcharges= new ArrayList<>();
        List<ModelSurcharge> output = surcharges.stream()
                                                .collect(groupingBy(p -> p.getcNoteDate(), 
                                                                    Collectors.summingDouble(p -> p.getSurcharge())));
    }
}
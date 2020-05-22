class NutritionAccumulator{
    private double fat = 0.;
    private double carbs = 0.;
    private double fiber = 0.;
    private double protein = 0.;

    public NutritionAccumulator() {
    }

    public NutritionAccumulator(double fat, double carbs, double fiber, double protein) {
        this.fat = fat;
        this.carbs = carbs;
        this.fiber = fiber;
        this.protein = protein;
    }

    public NutritionAccumulator add(NutritionAccumulator that){
        return new NutritionAccumulator(this.fat + that.fat,
        this.carbs + that.carbs,
        this.fiber + that.fiber,
        this.protein + that.protein
        );
    }
}
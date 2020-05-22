GET    /food/fetchMealInfo/:noOfDays/:dateSelected     controllers.trackandplan.FoodController.fetchMealInfo(noOfDays: Integer, dateSelected: Long)

public static Result fetchMealInfo(Integer noOfDays, Long dateSelected) {
    Date date = new Date(dateSelected.longValue());
    ...
}
public class Conf {

    @Nullable
    private static BusinessLogic businessLogic;

    @NonNull
    public static BusinessLogic getBusinessLogic() {

        if (businessLogic == null) {
            businessLogic = new BusinessLogic();
        }

        return businessLogic;
    }
}
public final class DataHolder {
    private static Map<String, Object> data = new HashMap<String, Object>();

    public static void setF_TaskId(int F_TaskId) {
        data.put("F_TaskId", F_TaskId);
    }

    public static int getF_TaskId() {
        Object resault = data.get("F_TaskId");
        return (Integer)resault;
    }
}
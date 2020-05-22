public enum Job {
    MEDIC(0),
    GARDENER(1);

    /**
     * get identifier value of this enum
     */
    private final byte value;

    private Job(byte value) {
        this.value = value;
    }

    /**
     * get identifier value of this enum
     * @return <i>int</i>
     */
    public int getValue() {
        return this.value;
    }

    /**
     * get enum which have value equals input string value
     * @param value <i>String</i> 
     * @return <i>Job</i>
     */
    public static Job getEnum(String value) {
        try {
            byte b = Byte.parseByte(value);
            for (Job c : Job.values()) {
                if (c.getValue() == b) {
                    return c;
                }
            }
            throw new Exception("Job does not exists!");
        } catch (NumberFormatException nfEx) {
            throw new Exception("Job does not exists!");
        }
    }

    /**
     * get name of this job
     */
    public String getName() {
        switch (this) {
        case MEDIC:
            return "Medic";
        case GARDENER:
            return "Gardener";
        default:
            throw new NotSupportedException();
        }
    }
}
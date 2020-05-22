abstract class Mapper {
    Boolean map(YN value) {
        return YN.Y.equals(value);
    }

    Boolean map(ZO value) {
        return ZO.O.equals(value);
    }
}
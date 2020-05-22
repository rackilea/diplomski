public class FatherSpecifications {
    public static Specification<Father> hasBirthdate(LocalDate birthdate) {
        return (father, cq, cb) -> Optional.ofNullable(birthdate).map(b -> cb.equal(father.get("birthdate"), b)).orElse(null);
    }

    public static Specification<Father> firstnameLike(String firstname) {
        return (father, cq, cb) -> Optional.ofNullable(firstname).map(f -> cb.like(father.get("firstname"), "%" + f + "%")).orElse(null);
    }

    public static Specification<Father> surnameLike(String surname) {
        return (father, cq, cb) -> Optional.ofNullable(surname).map(s -> cb.like(father.get("surname"), "%" + s + "%")).orElse(null);
    }
}
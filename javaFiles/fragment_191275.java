public interface TheEntityJpaRepository extends JpaRepository<TheEntity, Long> {
  @Modifying(clearAutomatically = true)
  @Query("UPDATE TheEntity SET status = :status WHERE id = :value")
  int markToStatus(@Param("value") Long value, @Param("status") TheStatusEnum status);

  default int markAsResolved(Long value) {
    return markToStatus(value, TheStatusEnum.RESOLVED);
  }
}

@Entity
public class YourEntity {
  ...
  @Enumerated(EnumType.STRING)
  private Status status;
  ...
}

public enum TheStatusEnum {
  RESOLVED,
  ...
}
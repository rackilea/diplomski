import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

public class Test {

  public static void main(String[] args) {
    CommUserDto dto = new CommUserDto();
    List<Long> commRolesId = new ArrayList<>();
    commRolesId.add(1L);
    List<Long> gnrlTransportersId = new ArrayList<>();
    dto.setGnrlTransportersId(gnrlTransportersId);
    dto.setCommRolesId(commRolesId);
    Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    Set<ConstraintViolation<CommUserDto>> constraintViolations = validator.validate(dto);
    System.out.println(constraintViolations.size());
    System.out.println(constraintViolations);
  }
}
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.xml.bind.annotation.XmlTransient;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class BusinessObject implements Serializable, IObjectWithReport, IBusinessObject {

  private static Log log = LogFactory.getLog(BusinessObject.class.getName());

  private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

  @JsonIgnore
  private Set<ConstraintViolation<BusinessObject>> errors;

  /* Validation methods */

  public final boolean valid() {
    preValidate();
    errors = new HashSet<ConstraintViolation<BusinessObject>>();
    errors = validator.validate(this);
    postValidate();
    return errors.isEmpty();
  }

  /**
   * Method to be overwriten in subclases so any BO can make some arrangement before checking valid
   */
  protected void preValidate() {
    log.trace("Generic prevalidate of " + this.getClass().getName());
  }
  /**
   * Method to be overwriten in subclases so any BO can make some arrangement once validation has been made
   */
  protected void postValidate() {
    log.trace("Generic postValidate of " + this.getClass().getName());
  }

  public Set<ConstraintViolation<BusinessObject>> getErrors() {
    return errors;
  }

  public boolean hasErrors() {
    return errors != null && !errors.isEmpty();
  }
}
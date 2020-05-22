package org.ovamba.business.serializer;

  import java.io.IOException;
  import org.webservice.business.dto.LoanApplication;
  import com.fasterxml.jackson.core.JsonGenerator;
  import com.fasterxml.jackson.core.JsonProcessingException;
  import com.fasterxml.jackson.databind.JsonSerializer;
  import com.fasterxml.jackson.databind.SerializerProvider;

 public class LoanApplicationSerializer extends JsonSerializer<LoanApplication> {

@Override
public void serialize(LoanApplication prm_objObjectToSerialize, JsonGenerator prm_objJsonGenerator, SerializerProvider prm_objSerializerProvider) throws IOException, JsonProcessingException {
    if (null == prm_objObjectToSerialize) {
    } else {
        try {
            prm_objJsonGenerator.writeStartObject();
            prm_objJsonGenerator.writeNumberField("applicationId", prm_objObjectToSerialize.getLoanApplicationId());
            prm_objJsonGenerator.writeStringField("status", prm_objObjectToSerialize.getStatus());
            prm_objJsonGenerator.writeNumberField("amount", prm_objObjectToSerialize.getAmount());
            prm_objJsonGenerator.writeNumberField("startdate", prm_objObjectToSerialize.getStartDate().getTime());
            prm_objJsonGenerator.writeNumberField("duration", prm_objObjectToSerialize.getDuration());
            prm_objJsonGenerator.writeStringField("businesstype", prm_objObjectToSerialize.getBusinessType());
            prm_objJsonGenerator.writeStringField("currency", prm_objObjectToSerialize.getCurrency());
            prm_objJsonGenerator.writeStringField("productcategory", prm_objObjectToSerialize.getProductCategory());
            prm_objJsonGenerator.writeStringField("purpose", prm_objObjectToSerialize.getPurpose());
            prm_objJsonGenerator.writeStringField("mystory", prm_objObjectToSerialize.getMyStory());
            prm_objJsonGenerator.writeStringField("salesRepresentative", prm_objObjectToSerialize.getSalesRepresentative());
        } catch (Exception v_exException) {
            //ExceptionController.getInstance().error("Error while Serializing the Loan Application Object", v_exException);
        } finally {
            prm_objJsonGenerator.writeEndObject();
        }
    }
  }
}

Hope This may help u alot. Thanks..